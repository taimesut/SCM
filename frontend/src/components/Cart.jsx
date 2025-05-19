import React, { useContext, useEffect, useState } from 'react';
import { AiOutlineClose } from "react-icons/ai";
import { MyUserContext } from '../context/MyUserContext';
import { loadStripe } from '@stripe/stripe-js';
import cookie from 'react-cookies';
import { MyCartContext } from '../context/MyCartContext';
import Apis, { endpoints } from '../configs/Apis';

const Cart = () => {
    const [cart, setCart] = useState(cookie.load('cart') || {});
    const user = useContext(MyUserContext);
    const [, cartDispatch] = useContext(MyCartContext);
    const token = cookie.load('token');

    const stripePromise = loadStripe('pk_test_51QvfvtANZWcy8zvUYdeK9BoZqyHsGQRH1jbD9K815TvxT6WBmanBgGYSqGYzchUS8mVCbBCQC2jPf80cZjAAjIKh00LSiQUxgY');

    const totalAmountVND = cart ? Object.values(cart).reduce((sum, item) => sum + item.price * item.quantity, 0) : 0;

    const removeItem = (id) => {
        const newCart = { ...cart };
        delete newCart[id];
        setCart(newCart);
        cookie.save('cart', newCart);
        cartDispatch({ type: 'update' });
        cartDispatch({ type: "REMOVE", payload: id });
    };

    const handleCheckout = async () => {
        if (!token) {
            alert("Bạn cần đăng nhập để thanh toán!");
            return;
        }

        if (!cart || totalAmountVND === 0) {
            alert("Giỏ hàng trống!");
            return;
        }

        try {
            const amountUSD_cents = Math.round(totalAmountVND / 23000 * 100);
            const response = await Apis.post(endpoints['payment'], { amount: amountUSD_cents });

            if (response.status !== 200) {
                alert('Lỗi tạo PaymentIntent');
                return;
            }
            const stripe = await stripePromise;

            const { sessionId } = response.data;
            const result = await stripe.redirectToCheckout({ sessionId });
            if (result.error) {
                alert(result.error.message);
            }

        } catch (error) {
            console.error(error);
            alert('Lỗi thanh toán, vui lòng thử lại.');
        }
    };

    useEffect(() => {
        if (!token) setCart({});
    }, [token]);

    return (
        <div className="min-h-screen flex flex-col justify-center items-center bg-gray-100 px-4 py-8">
            <div className="w-full max-w-screen-xl mx-auto px-6 py-8">
                <div className="text-center mb-6">
                    <h3 className="text-3xl font-semibold text-gray-900">Giỏ hàng của bạn</h3>
                    {Object.keys(cart).length === 0 && <span className='text-red-500 text-sm'>Chưa có sản phẩm nào trong giỏ</span>}
                </div>

                <div className="w-full flex flex-col lg:flex-row gap-6">
                    <div className="flex-1">
                        {Object.values(cart).map(c => (
                            <div key={c.id} className="flex gap-4 items-center bg-white shadow rounded p-4 mb-4">
                                <img src={c.image} alt={c.name} className="w-28 h-28 object-cover rounded" />
                                <div className="flex-1">
                                    <div className="flex justify-between items-center">
                                        <h4 className="text-lg font-bold text-gray-900">{c.name}</h4>
                                        <AiOutlineClose size={20} className='cursor-pointer text-gray-700' onClick={() => removeItem(c.id)} />
                                    </div>
                                    <p className="text-gray-500">{c.price.toLocaleString('vi-VN')}đ</p>
                                    <div className="flex justify-between mt-2 text-sm">
                                        <span>Số lượng: x{c.quantity}</span>
                                        <span>Thành tiền: {(c.price * c.quantity).toLocaleString('vi-VN')}đ</span>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>

                    {Object.keys(cart).length > 0 &&
                        <div className="w-full lg:w-1/3 bg-white shadow rounded p-6">
                            <h4 className="text-xl font-semibold mb-4">Thông tin đơn hàng</h4>
                            <div className="flex justify-between border-t border-b py-3">
                                <span className="text-gray-600">Tổng tiền:</span>
                                <span className="text-red-600 text-lg font-bold">{totalAmountVND.toLocaleString('vi-VN')}₫</span>
                            </div>
                            <p className="text-sm text-gray-500 mt-2">Phí vận chuyển và mã giảm giá sẽ được áp dụng ở bước thanh toán.</p>
                            <button
                                onClick={handleCheckout}
                                className="w-full bg-red-600 hover:bg-red-700 text-white py-3 rounded mt-4 transition duration-300">
                                Thanh Toán Ngay
                            </button>
                        </div>
                    }
                </div>
            </div>
        </div>
    );
};

export default Cart;
