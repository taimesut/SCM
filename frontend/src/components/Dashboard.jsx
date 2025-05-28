import React, { useContext, useEffect, useState } from 'react';
import user_icon from '../assets/user_icon.svg';
import { tabs, statusColors } from '../mockDatas/Status';
import { Link, useParams } from 'react-router-dom';
import cookie from 'react-cookies';
import { MdEdit } from 'react-icons/md';
import Apis, { authApis, endpoints } from '../configs/Apis';
import { MyUserContext } from '../context/MyUserContext';


const Dashboard = () => {
    const [activeTab, setActiveTab] = useState("all");
    const [isEditProfile, setIsEditProfile] = useState(true);

    const user = useContext(MyUserContext);

    const [orders, setOrders] = useState([]);

    const token = cookie.load('token');

    const [infoEdited, setInfoEdited] = useState({
        name: '',
        email: '',
        phone: '',
        address: '',
    });

    const loadAllOrders = async () => {
        try {
            let res = await authApis().get(endpoints['orders']);
            console.log("Orders data:", res.data);
            setOrders(res.data);
        } catch (err) {
            console.error("Failed to load profile:", err);
        }
    }

    const loadProfile = async () => {
        try {
            let res = await authApis().get(endpoints['profile']);
            console.log("Profile data:", res.data);
            setInfoEdited({
                name: res.data.name || '',
                email: res.data.email || '',
                phone: res.data.phone || '',
                address: res.data.address || '',
            });
        } catch (err) {
            console.error("Failed to load profile:", err);
        }
    };

    const updateProfile = async () => {
        try {
            const res = await authApis().put(endpoints['update'], infoEdited);
            console.log("Info gửi đi", infoEdited)
            alert("Cập nhật thành công!");
            setIsEditProfile(true);
            console.log("Cập nhật:", res.data);
        } catch (err) {
            console.error("Cập nhật thất bại:", err);
            alert("Cập nhật thất bại!");
        }
    };

    useEffect(() => {
        if (token) {
            loadProfile();
            loadAllOrders();
        }
        console.log(user)
    }, []);

    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setInfoEdited(prev => ({
            ...prev,
            [name]: value
        }));

        if (errors[name]) {
            setErrors(prev => ({
                ...prev,
                [name]: ''
            }));
        }
    };

    const validateForm = () => {
        const newErrors = {};

        if (!infoEdited.name.trim()) newErrors.name = 'Vui lòng nhập tên';
        if (!infoEdited.email.trim()) {
            newErrors.email = 'Vui lòng nhập email';
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(infoEdited.email)) {
            newErrors.email = 'Email không hợp lệ';
        }
        if (!infoEdited.phone.trim()) newErrors.phone = 'Vui lòng nhập số điện thoại';
        if (!infoEdited.address.trim()) newErrors.address = 'Vui lòng nhập địa chỉ';

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const getStatusColor = (status) => statusColors[status] || "text-gray-500";

    const filterOrder = (status) => {
        if (status === "all") return orders;
        return orders.filter(o => o.receiptExportId.status === status);
    };

    const filteredOrders = filterOrder(activeTab);

    const cancelReceipt = async (id) => {
        try {
        let res = await authApis().put(endpoints['cancel-receipt'](id));
        alert("Đã huỷ đơn hàng thành công!");
        await loadAllOrders(); 
    } catch (err) {
        console.error("Lỗi huỷ đơn hàng:", err);
        alert("Huỷ đơn hàng thất bại!");
    }
    }

    return (
        <div className="min-h-screen flex flex-col justify-center items-center bg-gray-100 px-4 py-8">
            <div className="w-full flex h-screen max-w-screen-xl  mx-auto px-6 py-8">
                <div className="left h-full flex-3 flex flex-col mt-24">
                    <div className="profile flex gap-4">
                        <div className="border-1 border-gray-300 p-2 w-14 rounded-full cursor-pointer hover:shadow-sm">
                            <img src={user_icon} alt="" className='w-full object-cover ' />
                        </div>
                        <div className="flex flex-col gap-2 w-full">
                            <span>{user?.username || "Anonymous"}</span>
                            <div className="flex items-center w-full text-gray-500">
                                {infoEdited.address !== "" ? <span>{infoEdited.address}</span> : "Thêm địa chỉ"}<MdEdit onClick={() => setIsEditProfile(!isEditProfile)} className='text-gray-400 cursor-pointer' size={19} />
                            </div>
                        </div>
                    </div>
                    <div className="info mt-5">
                        <h2 className='text-black text-xl font-semibold mb-2'>Thông tin tài khoản</h2>
                        <div className='flex flex-col gap-3'>
                            <div className="w-auto">
                                <span className='me-5'>Họ và tên: </span>
                                <input
                                    className='p-3 bg-gray-200'
                                    name='name'
                                    value={infoEdited.name || ''}
                                    onChange={handleChange}
                                    readOnly={isEditProfile}
                                    placeholder="Họ và tên"
                                />
                                {errors.name && !isEditProfile && <span className="text-red-500 text-sm ms-25">{errors.name}</span>}
                            </div>
                            <div className="w-auto">
                                <span className='me-12'>Email: </span>
                                <input
                                    className='p-3 bg-gray-200'
                                    name='email'
                                    value={infoEdited.email || ''}
                                    onChange={handleChange}
                                    readOnly={isEditProfile}
                                    placeholder="Email"
                                />
                                {errors.email && !isEditProfile && <span className="text-red-500 text-sm ms-25">{errors.email}</span>}
                            </div>
                            <div className="w-auto">
                                <span className='me-8'>Liên lạc: </span>
                                <input
                                    className='p-3 bg-gray-200'
                                    name='phone'
                                    value={infoEdited.phone || ''}
                                    onChange={handleChange}
                                    readOnly={isEditProfile}
                                    placeholder="Số điện thoại"
                                />
                                {errors.phone && !isEditProfile && <span className="text-red-500 text-sm ms-25">{errors.phone}</span>}
                            </div>
                            {!isEditProfile && (
                                <div>
                                    <div className="w-auto flex-col">
                                        <div className="info">
                                            <span className='me-9'>Địa chỉ: </span>
                                            <input
                                                className='p-3 bg-gray-200'
                                                name='address'
                                                value={infoEdited.address || ''}
                                                onChange={handleChange}
                                                readOnly={isEditProfile}
                                                placeholder="Địa chỉ"
                                            />
                                        </div>
                                        {errors.address && <span className="text-red-500 text-sm ms-25">{errors.address}</span>}
                                    </div>
                                    <div className="flex px-18 justify-end">
                                        <button
                                            className="mt-4 px-4 py-2 bg-gray-500 text-white rounded cursor-pointer"
                                            onClick={() => {
                                                if (validateForm()) {
                                                    updateProfile();
                                                }
                                            }}

                                        >
                                            Cập nhật
                                        </button>
                                    </div>
                                </div>
                            )}
                        </div>
                    </div>
                </div>
                <div className="right flex-7 flex flex-col mt-24">
                    <div className="bg-white border-b border-gray-200">
                        <div className="flex space-x-6 px-4 justify-around items-center">
                            {tabs.map((tab) => (
                                <button
                                    key={tab.key}
                                    onClick={() => setActiveTab(tab.key)}
                                    className={`relative py-4 text-md font-medium transition-colors cursor-pointer ${activeTab === tab.key
                                        ? "text-[#ee4d2d] after:absolute after:left-0 after:right-0 after:bottom-0 after:h-0.5 after:bg-[#ee4d2d] "
                                        : "text-gray-800 hover:text-[#ee4d2d]"
                                        }`}
                                >
                                    <Link to={`/dashboard/purchase/${tab.key}`}>{tab.label}</Link>
                                </button>
                            ))}
                        </div>
                        <div className="p-4 flex flex-col gap-3">
                            {filteredOrders?.map((o) => (
                                <div key={o.id} className="w-full flex gap-2">
                                    <div className="flex-2 image border-1 border-gray-400 rounded-sm">
                                        <img src={o.productId.image} alt="" className='w-full object-center' />
                                    </div>
                                    <div className="flex-8 product-info flex flex-col gap-2">
                                        <div className="flex justify-between items-center">
                                            <span>{o.productId.name}</span>
                                            <span className={`font-semibold ${getStatusColor(o.receiptExportId.status)}`}>
                                                {tabs.find(t => t.key === o.receiptExportId.status)?.label || o.receiptExportId.status}
                                            </span>

                                        </div>
                                        <span className='text-gray-400 text-sm'>Phân loại hàng: {o.productId.categoryId.name}</span>
                                        <p>x{o.amount}</p>
                                        <div className="flex justify-between">
                                            <p>{o.productId.price}&#8363;</p>
                                            {o.receiptExportId.status === "ordered" && (
                                                <button className='text-white bg-red-500 font-semibold cursor-pointer p-2 rounded-sm' onClick={()=>cancelReceipt(o.receiptExportId.id)}>
                                                    Huỷ hàng
                                                </button>
                                            )}
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Dashboard;
