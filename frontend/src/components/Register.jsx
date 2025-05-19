import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

import Apis, { endpoints } from '../configs/Apis';

const Register = () => {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        phoneNumber: '',
        username: '',
        password: '',
        confirmPassword: '',
        address: '',
        avatar: null
    });

    const [errors, setErrors] = useState({});
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value, files } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: files ? files[0] : value
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

        if (!formData.name.trim()) newErrors.name = 'Vui lòng nhập tên';
        if (!formData.email.trim()) {
            newErrors.email = 'Vui lòng nhập email';
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
            newErrors.email = 'Email không hợp lệ';
        }
        if (!formData.phoneNumber.trim()) newErrors.phoneNumber = 'Vui lòng nhập số điện thoại';
        if (!formData.address.trim()) newErrors.address = 'Vui lòng nhập địa chỉ';
        if (!formData.username.trim()) newErrors.username = 'Vui lòng nhập tên đăng nhập';
        if (!formData.avatar) newErrors.avatar = 'Vui lòng chọn ảnh đại diện';
        if (!formData.password) {
            newErrors.password = 'Vui lòng nhập mật khẩu';
        } else if (formData.password.length < 6) {
            newErrors.password = 'Mật khẩu phải có ít nhất 6 ký tự';
        }
        if (formData.password !== formData.confirmPassword) {
            newErrors.confirmPassword = 'Mật khẩu không khớp';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            try {
                const data = new FormData();
                data.append("name", formData.name);
                data.append("email", formData.email);
                data.append("phone", formData.phoneNumber);
                data.append("username", formData.username);
                data.append("password", formData.password);
                data.append("address", formData.address);
                data.append("avatar", formData.avatar);

                const response = await Apis.post(endpoints['register'], data, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });

                if (response.data?.success || response.status === 201 || response.status === 200) {
                    navigate('/login');
                } else {
                    setErrors(prev => ({ ...prev, global: response.data.message || 'Đăng ký thất bại' }));
                }
            } catch (error) {
                console.error("Đăng ký thất bại:", error);
                setErrors(prev => ({ ...prev, global: "Đã có lỗi xảy ra. Vui lòng thử lại." }));
            }
        }
    };

    return (
        <div className="min-h-screen flex flex-col justify-center items-center bg-gray-100 px-4 py-8">
            <div className="w-full max-w-xl bg-white p-8 rounded shadow mt-10">
                <h1 className="text-2xl font-bold text-center mb-6">PHIẾU ĐĂNG KÝ</h1>

                <form onSubmit={handleSubmit} className="space-y-6">
                    <div className="flex gap-6 w-full">
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Họ & tên<span className='text-red-500'>*</span></label>
                            <input
                                name="name"
                                value={formData.name}
                                onChange={handleChange}
                                placeholder='Nhập họ và tên'
                                className={`w-full px-3 py-2 border ${errors.name ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.name && <p className="text-xs text-red-500 mt-1">{errors.name}</p>}
                        </div>
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Email<span className='text-red-500'>*</span></label>
                            <input
                                type='email'
                                name="email"
                                value={formData.email}
                                onChange={handleChange}
                                placeholder='Nhập địa chỉ email'
                                className={`w-full px-3 py-2 border ${errors.email ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.email && <p className="text-xs text-red-500 mt-1">{errors.email}</p>}
                        </div>
                    </div>

                    <div className="flex gap-6 w-full">
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Địa chỉ<span className='text-red-500'>*</span></label>
                            <input
                                name="address"
                                value={formData.address}
                                onChange={handleChange}
                                placeholder='Nhập địa chỉ'
                                className={`w-full px-3 py-2 border ${errors.address ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.address && <p className="text-xs text-red-500 mt-1">{errors.address}</p>}
                        </div>
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Số điện thoại<span className='text-red-500'>*</span></label>
                            <input
                                name="phoneNumber"
                                value={formData.phoneNumber}
                                onChange={handleChange}
                                placeholder='Nhập số điện thoại'
                                className={`w-full px-3 py-2 border ${errors.phoneNumber ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.phoneNumber && <p className="text-xs text-red-500 mt-1">{errors.phoneNumber}</p>}
                        </div>
                    </div>

                    <div className="flex gap-6 w-full">
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Tên đăng nhập<span className='text-red-500'>*</span></label>
                            <input
                                name="username"
                                value={formData.username}
                                onChange={handleChange}
                                placeholder='Nhập tên đăng nhập'
                                className={`w-full px-3 py-2 border ${errors.username ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.username && <p className="text-xs text-red-500 mt-1">{errors.username}</p>}
                        </div>
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Mật khẩu<span className='text-red-500'>*</span></label>
                            <input
                                type="password"
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                                placeholder='Nhập mật khẩu'
                                className={`w-full px-3 py-2 border ${errors.password ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.password && <p className="text-xs text-red-500 mt-1">{errors.password}</p>}
                        </div>
                    </div>

                    <div className="flex gap-6 w-full">
                        <div className='flex-1'>
                            <label className="block text-sm font-semibold mb-1">Nhập lại mật khẩu<span className='text-red-500'>*</span></label>
                            <input
                                type='password'
                                name="confirmPassword"
                                value={formData.confirmPassword}
                                onChange={handleChange}
                                placeholder='Nhập lại mật khẩu'
                                className={`w-full px-3 py-2 border ${errors.confirmPassword ? 'border-red-400' : 'border-gray-300'} rounded`}
                            />
                            {errors.confirmPassword && <p className="text-xs text-red-500 mt-1">{errors.confirmPassword}</p>}
                        </div>
                    </div>

                    <div className="flex gap-6 w-full items-center">
                        <label className="block text-sm font-semibold mb-1 w-32">Ảnh đại diện<span className='text-red-500'>*</span></label>
                        <input
                            type='file'
                            name="avatar"
                            onChange={handleChange}
                            className={`flex-1 px-3 py-2 border ${errors.avatar ? 'border-red-400' : 'border-gray-300'} rounded`}
                        />
                        {errors.avatar && <p className="text-xs text-red-500 mt-1">{errors.avatar}</p>}
                    </div>

                    {errors.global && <p className="text-red-500 text-sm text-center">{errors.global}</p>}

                    <button
                        type="submit"
                        className="w-full bg-gray-800 text-white py-3 rounded font-semibold hover:bg-gray-900 transition cursor-pointer"
                    >
                        ĐĂNG KÝ
                    </button>
                </form>

                <p className="text-center text-sm mt-6 text-gray-500">
                    Đã có tài khoản? <Link to="/login" className="text-blue-500 hover:underline">Đăng nhập</Link>
                </p>
            </div>
        </div>
    );
};

export default Register;
