import React, { useContext, useState } from 'react';
import { useNavigate, useSearchParams, Link } from 'react-router-dom';
import Apis, { endpoints } from '../configs/Apis';
import { MyDispatchContext } from '../context/MyDispatchContext';
import { authApis } from '../configs/Apis';
import cookie from 'react-cookies';

const Login = () => {
  const info = [
    { label: "Tên đăng nhập", type: "text", field: "username" },
    { label: "Mật khẩu", type: "password", field: "password" }
  ];

  const dispatch = useContext(MyDispatchContext);
  const [q] = useSearchParams();
  const next = q.get('next');
  const nav = useNavigate();

  const [user, setUser] = useState({});
  const [errors, setErrors] = useState({});
  const [apiError, setApiError] = useState('');
  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
    setErrors({ ...errors, [e.target.name]: '' });
    setApiError('');
  };

  const validate = () => {
    const newErrors = {};
    if (!user.username) newErrors.username = 'Vui lòng nhập tên đăng nhập';
    if (!user.password) newErrors.password = 'Vui lòng nhập mật khẩu';
    else if (user.password.length < 6) newErrors.password = 'Mật khẩu phải có ít nhất 6 ký tự';
    return newErrors;
  };

  const login = async (e) => {
    e.preventDefault();

    const validationErrors = validate();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
      return;
    }

    try {
      setLoading(true);
      let res = await Apis.post(endpoints['login'], user);
      cookie.save('token', res.data.token,{ path: '/', maxAge: 3600 });
      console.log(res.data.token)
      let u = await authApis().get(endpoints['profile']);
      dispatch({ type: 'login', payload: u.data });

      nav(next ? next : '/');
    } catch (err) {
      if (err.response && err.response.status === 401) {
        setApiError('Tên đăng nhập hoặc mật khẩu không đúng');
      } 
      console.log(err)
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="w-full h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-xl">
        <h2 className="text-2xl font-bold mb-6 text-center">ĐĂNG NHẬP</h2>
        <form onSubmit={login} className="space-y-6">
          {apiError && <p className="text-red-500 text-center">{apiError}</p>}

          {info.map((i) => (
            <div key={i.field}>
              <label className="block text-sm font-medium mb-1">
                {i.label} <span className="text-red-500">*</span>
              </label>
              <input
                type={i.type}
                name={i.field}
                value={user[i.field] || ''}
                onChange={handleChange}
                className={`w-full px-4 py-2 border ${
                  errors[i.field] ? 'border-red-500' : 'border-gray-300'
                } rounded focus:outline-none focus:ring-1 focus:ring-gray-400`}
                placeholder={i.label}
              />
              {errors[i.field] && (
                <p className="text-xs text-red-500 mt-1">{errors[i.field]}</p>
              )}
            </div>
          ))}

          <button
            type="submit"
            disabled={loading}
            className={`w-full py-3 rounded font-semibold text-white ${
              loading ? 'bg-gray-500 cursor-not-allowed' : 'bg-gray-800 hover:bg-gray-900'
            } transition`}
          >
            {loading ? 'Đang xử lý...' : 'ĐĂNG NHẬP'}
          </button>

          <p className="text-center text-sm text-gray-500">
            Chưa có tài khoản?{' '}
            <Link to="/register" className="text-blue-500 hover:underline">
              Đăng ký ngay
            </Link>
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;
