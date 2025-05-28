export const tabs = [
    { label: "Tất cả", key: "all" },
     { label: "Đã đặt hàng", key: "ordered" },
    { label: "Đã xác nhận", key: "confirmed" },
    { label: "Đang giao", key: "shipping" },
    { label: "Đã giao", key: "completed" },
    { label: "Đã huỷ", key: "cancelled" },
];

export const statusColors = {
    "ordered":  "text-yellow-500",
    "confirmed": "text-gray-500",
    "shipping": "text-blue-500",
    "completed": "text-green-600",
    "cancelled": "text-red-500",
};

export const PaymentMethod ={
    "Banking": "Chuyển khoản",
    "Cod": "Tiền mặt"
}