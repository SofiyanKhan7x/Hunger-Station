export default function Button({
  children,
  type = "button",
  onClick,
  disabled = false,
  className = "",
}) {
  return (
    <button
      type={type}
      onClick={onClick}
      disabled={disabled}
      className={`
        inline-flex items-center justify-center
        font-sans font-semibold
        rounded-xl px-5 py-3 text-base
        tracking-wide
        transition-all duration-300 ease-out
        focus:outline-none focus:ring-3 focus:ring-offset-2 focus:ring-black/20
        active:scale-[0.98]
        disabled:pointer-events-none
        shadow-sm hover:shadow-md
        ${
          disabled
            ? "bg-gray-100 text-gray-400 shadow-none"
            : "bg-[#BF1E2E] text-white hover:bg-[#9F1826] hover:shadow-lg active:shadow-md"
        }
        ${className}
      `}
    >
      <span className="flex items-center justify-center gap-2">{children}</span>
    </button>
  );
}
