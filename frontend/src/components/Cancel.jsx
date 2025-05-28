import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import cookie from 'react-cookies';
import Apis, { endpoints } from "../configs/Apis";

const Cancel = () => {
    const nav = useNavigate();
    const urlParams = new URLSearchParams(window.location.search)


    const orderCode = urlParams.get('orderCode');
    const status = urlParams.get('status');

    const data = {
        orderCode: orderCode ?? "",
        status: status ?? ""
    }

    const updateInvoice = async () => {
        try {
            console.log("Token hiện tại:", cookie.load('token'));
            const token = cookie.load('token');
            let response = await Apis.put(endpoints['payment-update'], data, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                }
            });

            if (response.status === 200 || response != null) {
                alert("Cập nhật thành công");
            }
        } catch (error) {
            console.error("Lỗi cập nhật:", error.response?.data || error.message);
        }
    };

    useEffect(() => {
        updateInvoice()
    }, [])

    return (
        <div className="text-center py-10 h-screen w-full flex items-center justify-center flex-col">
            <h1 className="text-2xl text-red-500 font-bold">Thanh toán thất bại!</h1>
            <p className="text-gray-400">Vui lòng thử lại.</p>
            <button className="text-white bg-emerald-600 font-semibold p-3 mt-3 border-2 border-emerald-500 rounded-2xl cursor-pointer" onClick={() => nav("/")}>Trở về trang chủ</button>
        </div>
    )
}

export default Cancel;
