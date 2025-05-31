import React from 'react';

const Footer = () => {
  return (
    <footer className="bg-gray-800 text-white py-6 mt-10 z-50">
      <div className="max-w-6xl mx-auto px-4 text-center">
        <p className="text-sm">&copy; {new Date().getFullYear()} <span className='text-red-500'>TShop</span>. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
