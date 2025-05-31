import React, { useContext, useEffect, useState } from 'react'
import { FaReceipt, FaMoneyCheckAlt, FaTruck, FaBoxOpen, FaStar } from 'react-icons/fa';
import Apis, { authApis, endpoints } from '../configs/Apis';
import { useParams } from 'react-router-dom';
import { MyUserContext } from '../context/MyUserContext';


const DetailOrder = () => {
    const [deliverSchedule, setDeliverSchedule] = useState([]);
    const [statusDeliver, setStatusDeliver] = useState(null);
    const [statusOrder, setStatusOrder] = useState(null);
    const { receiptExportId } = useParams();
    const user = useContext(MyUserContext);

    const [rating, setRating] = useState(5);
    const [review, setReview] = useState("");
    const [hoverRating, setHoverRating] = useState(0);




    const loadDeliverSchedule = async () => {
        let response = await Apis.get(endpoints["deliver-schedule"](receiptExportId));
        if (response.data && response) {
            setDeliverSchedule(response.data);
            setStatusDeliver(response.data[0]);
            console.log("Tg: ", response.data[0]?.shipmentId?.note);
        }
    }

    const getStatusOrder = async () => {
        let response = await authApis().get(endpoints["receipt-export"](receiptExportId));
        console.log("Receipt ", response.data)
        if (response.data && response) {
            setStatusOrder(response.data)
        }
    }

    const handleRating = async () => {
        try {
            const payload = {
                shipmentId: { id: statusDeliver?.shipmentId?.id },
                performance: rating,
                note: review
            };
            console.log(payload)
            let response = await authApis().post(endpoints["rating"], payload);
            if (response.data) {
                alert("Đánh giá của bạn đã được gửi");
                setReview("");
                setRating(0);
            }
        } catch (error) {
            console.error("Gửi đánh giá lỗi:", error);
            alert("Có lỗi khi gửi đánh giá, vui lòng thử lại!");
        }
    };


    useEffect(() => {
        console.log(user)
        if (receiptExportId) {
            loadDeliverSchedule();
            getStatusOrder();
        }
    }, [receiptExportId, user]);

    const steps = [
        {
            icon: <FaReceipt className="text-3xl text-green-500" />,
            title: "Đơn Hàng Đã Đặt",
            time: statusOrder?.createDate
        },
        {
            icon: <FaMoneyCheckAlt className="text-3xl text-gray-500" />,
            title: "Đã Xác Nhận Thông Tin Thanh Toán",
            time: statusOrder?.createDate
        },
        {
            icon: <FaTruck className="text-3xl text-gray-500" />,
            title: "Đã Giao Cho ĐVVC",
            time: deliverSchedule[0]?.shipmentId?.note
        },
        {
            icon: <FaBoxOpen className="text-3xl text-gray-500" />,
            title: "Đã Nhận Được Hàng",
            time: statusOrder?.status === "completed" ? statusOrder?.note : ""
        },
        {
            icon: <FaStar className={`text-3xl ${statusDeliver?.shipmentId?.reviewShipmentCompany ? "text-green-500" : "text-gray-500"}`} />,
            title: "Đơn Hàng Đã Hoàn Thành",
            time: statusDeliver?.shipmentId?.reviewShipmentCompany ? new Date().getTime(): ""
        }

    ];


    return (
        <div className="text-center py-10 h-screen w-full flex items-center justify-center flex-col p-2">
            <div className="flex justify-center items-center py-10 overflow-x-auto">
                <div className="flex space-x-12">
                    {steps.map((step, index) => (

                        <div key={index} className="flex flex-col items-center text-center min-w-[200px]">
                            <div className={`w-16 h-16 rounded-full border-4 ${step.time || (statusOrder && index === 0) ? "border-green-500" : "border-gray-500"} flex items-center justify-center bg-white z-10 relative`}>
                                {React.cloneElement(step.icon, {
                                    className: `text-3xl ${step.time || (statusOrder && index === 0) ? "text-green-500" : "text-gray-500"}`
                                })}
                                {index < steps.length - 1 && (
                                    <div className={`h-1 w-50 ${step.time || (statusOrder && index === 0) ? "bg-green-500" : "bg-gray-500"}  absolute left-full z-0`}></div>
                                )}
                            </div>
                            <div className="mt-2 text-sm font-semibold">{step.title}</div>
                            <div className="text-xs text-gray-500">
                                {step.time
                                    ? new Date(step.time).toLocaleDateString("vi-VN") || step.time
                                    : "Đang tải..."}
                            </div>
                        </div>
                    ))}
                </div>
            </div>
            <div className="flex gap-3 w-full px-60">
                <div className="info-express flex flex-col items-start p-2">
                    <h2 className='text-3xl mb-4 font-semibold'>Địa chỉ nhận hàng</h2>
                    {user ? <>
                        <span>{user.name}</span>
                        <span>(+84) {user.phone.slice(1)}</span>
                        <span>{user.address}</span></> : ""}
                </div>
                <div className="location flex flex-col items-start p-2 ms-10">
                    <h2 className='text-3xl mb-4 font-semibold'>Thông tin đơn hàng</h2>
                    <div className='flex gap-1 items-center mb-5'>
                        <div className="w-5 h-5 bg-green-500 rounded-full relative"><div className={`h-8 w-1 bg-green-500 absolute top-full left-2 z-0 ${!deliverSchedule ? "hidden" : ""}`}></div></div>
                        <span>Đặt hàng thành công</span>

                    </div>
                    {deliverSchedule.map((p, index) => (
                        <div
                            key={index}
                            className='flex gap-1 items-center mb-5'
                        >
                            <div className={`w-5 h-5 ${p.status === "Chưa tới" ? "bg-gray-500" : "bg-green-500"} rounded-full relative`}>
                                {(statusOrder?.status === "completed" ? index < deliverSchedule.length : index < deliverSchedule.length - 1) && (
                                    <div className={`h-8 w-1 ${p.status === "Chưa tới" ? "bg-gray-500" : "bg-green-500"} absolute top-full left-1/3 z-0`}></div>
                                )}
                            </div>
                            <span>{p.address}</span>
                        </div>
                    ))}
                    {statusOrder?.status === "completed" ? <div className="flex gap-1 items-center"> <div className="w-5 h-5 bg-green-500 rounded-full"></div>
                        <span>Hoàn thành</span></div> : ""}
                </div>
                {!statusDeliver?.shipmentId?.reviewShipmentCompany &&  statusOrder?.status === "completed"?
                    <div className="evaluation p-3 w-1/3">
                        <h2 className='text-3xl mb-4 font-semibold'>Đánh giá của bạn</h2>
                        <div className="flex items-center mb-3 ms-6">
                            {[1, 2, 3, 4, 5].map((value) => (
                                <FaStar
                                    key={value}
                                    onClick={() => setRating(value)}
                                    onMouseEnter={() => setHoverRating(value)}
                                    onMouseLeave={() => setHoverRating(0)}
                                    className={`text-3xl cursor-pointer transition-colors 
                                ${value <= (hoverRating || rating) ? 'text-yellow-400' : 'text-gray-400'}`}
                                />
                            ))}
                        </div>
                        <textarea
                            rows={3}
                            placeholder='Viết đánh giá của bạn?'
                            className='w-full p-2 border rounded resize-none ms-6'
                            value={review}
                            onChange={(e) => setReview(e.target.value)}
                        />
                        {(rating > 0 && review.trim() !== "") && (
                            <button
                                onClick={handleRating}
                                className="mt-4 px-4 py-2 bg-green-600 text-white rounded hover:bg-green-700 transition"
                            >
                                Gửi đánh giá
                            </button>
                        )}
                    </div> : ""
                }
            </div>
        </div>
    )
}

export default DetailOrder
