import React, { useContext, useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import cart_icon from '../assets/cart_icon.svg'
import user_icon from '../assets/user_icon.svg'
import { MyUserContext } from '../context/MyUserContext';
import Apis, { endpoints } from '../configs/Apis';
import { MyCartContext } from '../context/MyCartContext';
import { MyDispatchContext } from '../context/MyDispatchContext';



const Navbar = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const user = useContext(MyUserContext);
  const [categories, setCategories] = useState([]);
  const dispatch = useContext(MyDispatchContext)
  const [cart, cartDispatch] = useContext(MyCartContext);

  const nav = useNavigate();

  const loadCates = async () => {
    try {
      let res = await Apis.get(endpoints['categories']);
      if (res && res.data && Array.isArray(res.data)) {
        setCategories(res.data);
      } else {
        console.error('Dữ liệu danh mục không hợp lệ:', res.data);
      }
    } catch (error) {

      console.error('Lỗi khi tải danh mục:', error);
      alert('Có lỗi xảy ra khi tải danh mục. Vui lòng thử lại!');
    }
  };

  useEffect(() => {
    loadCates()
  }, [])

  return (
    <nav className='fixed top-0 left-0 right-0 bg-white/90 backdrop-blur-sm z-50 border-gray-100 shadow-sm'>
      <div className="w-full max-w-screen-xl mx-auto px-6 flex items-center justify-between md:h-20 h-16">
        <div className="cursor-pointer font-semibold hover:opacity-75">
          <Link to="/">TSHOP.</Link>
        </div>

        {/* Desktop Navigation */}
        <div className="hidden md:flex items-center gap-8">
          <Link
            to={`/products`}
            className={`font-medium transition-colors hover:text-primary uppercase`}
          >
            tất cả
          </Link>
          {categories.map((cate) => (
            <Link
              key={cate.id}
              to={`/products?categoryId=${cate.id}`}
              className={`font-medium transition-colors hover:text-primary uppercase`}
            >
              {cate.name}
            </Link>
          ))}
        </div>

        {/* Mobile Menu Button */}
        <button
          className="md:hidden p-2"
          onClick={() => setIsMenuOpen(!isMenuOpen)}
        >
          <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
          </svg>
        </button>

        {/* User side */}
        <div className="hidden md:flex items-center gap-5">
          {user === null ? <div className="flex justify-between">
            <Link to="/register"><span className='font-semibold'>ĐĂNG KÝ</span></Link>
            <span>/</span>
            <Link to="/login"><span className='font-semibold'>ĐĂNG NHẬP</span></Link>
          </div> : <div className="border-1 border-gray-400 rounded-full cursor-pointer">
            <Link to="/dashboard/purchase/all">
              <img src={user.avatar} className='w-10 h-10 object-cover rounded-full border-2 border-gray-300 shadow' />
            </Link>
          </div>
          }
          <div className="flex justify-between relative cursor-pointer">
            <Link to="/cart"><img src={cart_icon} alt="cart" className='size-6' /></Link>
            <span className='absolute -top-2 -right-2 bg-red-500 text-white text-xs font-bold rounded-full w-5 h-5 flex items-center justify-center'>{cart}</span>
          </div>
          {user !== null ? <button className='cursor-pointer' onClick={() => {dispatch({"type": "logout"}); cartDispatch({ "type": "paid" }); nav("/")}}><span className='font-semibold'>ĐĂNG XUẤT</span></button> : ""}

        </div>

      </div>
      {/* Mobile Menu */}
      {isMenuOpen && (
        <div className="md:hidden bg-white py-4 px-6 shadow-lg cursor-pointer">
          {navLinks.map((link) => (
            <a
              key={link.path}
              href={link.path}
              className={`block py-2 text-sm font-medium`}
              onClick={(e) => {
                setIsMenuOpen(false);
              }}
            >
              {link.label}
            </a>
          ))}
        </div>
      )}
    </nav>
  );
};

export default Navbar;