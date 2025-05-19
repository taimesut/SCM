import React, { useState, useEffect, useContext } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import Apis, { endpoints } from '../configs/Apis';
import { MyCartContext } from '../context/MyCartContext';
import cookie from 'react-cookies'

const Product = () => {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const nav = useNavigate();

  const categoryId = queryParams.get("categoryId");
  const fromPrice = queryParams.get("fromPrice");
  const toPrice = queryParams.get("toPrice");

  const [cart, cartDispatch] = useContext(MyCartContext);

  const [formData, setFormData] = useState({
    fromPrice: '',
    toPrice: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };



  const [products, setProducts] = useState([]);

  useEffect(() => {
  const loadProducts = async () => {
    try {
      const res = await Apis.get(endpoints['products']);
      let filtered = res.data;

      if (categoryId)
        filtered = filtered.filter(p => String(p.categoryId.id) === categoryId);

      if (fromPrice)
        filtered = filtered.filter(p => p.price >= parseInt(fromPrice));

      if (toPrice)
        filtered = filtered.filter(p => p.price <= parseInt(toPrice)); 

      setProducts(filtered);
    } catch (err) {
      console.error(err);
    }
  };

  loadProducts();
}, [categoryId, fromPrice, toPrice]);


  const handleAddToCart = (p) => {
    let cart = cookie.load("cart") || {};

    
    if (p.id in cart) {
      cart[p.id]['quantity']++;
    } else {
      cart[p.id] = {
        "id": p.id,
        "name": p.name,
        "price": p.price,
        'image': p.image,
        'note': p.note,
        "quantity": 1
      }
    }
    cookie.save('cart', cart);
    console.info(cart);

    cartDispatch({
      "type": "update"
    })
  };

  const handleBuyNow = (product) => {
    alert(`Mua ngay sản phẩm: ${product.name}`);
  };

  return (
    <div className="min-h-screen flex flex-col items-center bg-gray-100 px-4 py-8">
      <div className="search-area grid grid-cols-2 md:grid-cols-4 gap-4 mb-6 mt-20">
        <div className="group-input">
          <label className="block text-sm font-semibold mb-1">Giá từ</label>
          <input
            type="number"
            name="fromPrice"
            value={formData.fromPrice}
            onChange={handleChange}
            placeholder="VD: 1000000"
            className="w-full px-3 py-2 border border-gray-300 rounded"
          />
        </div>
        <div className="group-input">
          <label className="block text-sm font-semibold mb-1">Giá đến</label>
          <input
            type="number"
            name="toPrice"
            value={formData.toPrice}
            onChange={handleChange}
            placeholder="VD: 5000000"
            className="w-full px-3 py-2 border border-gray-300 rounded"
          />
        </div>
        <div className="flex items-end">
          <button
            className="bg-gray-800 text-white font-semibold px-4 py-2 rounded cursor-pointer"
            onClick={() => {
              const params = new URLSearchParams(location.search);

              if (formData.fromPrice && formData.toPrice) {
                if (parseInt(formData.fromPrice) > parseInt(formData.toPrice)) {
                  alert("Giá tiền tìm không hợp lệ!!!")
                  setFormData({ fromPrice: '', toPrice: '' })
                  nav("/products")
                  return;
                }
              }
              if (formData.fromPrice)
                params.set("fromPrice", formData.fromPrice);
              else
                params.delete("fromPrice");

              if (formData.toPrice)
                params.set("toPrice", formData.toPrice);
              else
                params.delete("toPrice");


              nav(`/products?${params.toString()}`);
            }}
          >
            Tìm theo giá
          </button>
        </div>
      </div>
      <div className="w-full max-w-screen-xl mx-auto px-6 py-8">
        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-3 xl:grid-cols-4 p-3 gap-6">
          {products.length > 0 ? products.map((product) => (
            <div key={product.id} className="rounded-xl bg-white p-4 max-w-xl shadow hover:shadow-lg transition">
              <img src={product.image} alt={product.name} className="w-full h-60 object-cover mb-4 rounded" />
              <h3 className="text-lg font-semibold">{product.name}</h3>
              <p className="text-red-500 font-bold mt-2">{product.price}₫</p>
              <div className="flex items-center gap-4 mt-2">
                <button
                  className="bg-gray-800 text-white font-semibold p-2 rounded-sm cursor-pointer"
                  onClick={() => handleBuyNow(product)}
                >
                  Mua ngay
                </button>
                <button
                  className="bg-gray-800 text-white font-semibold px-4 py-2 rounded-sm cursor-pointer"
                  onClick={() => handleAddToCart(product)}
                >
                  Thêm giỏ hàng
                </button>
              </div>
            </div>
          )) : "Không có sản phẩm nào hợp lệ"}
        </div>
      </div>
    </div>
  );
};

export default Product;
