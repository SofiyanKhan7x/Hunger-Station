
export default function Input({
  label,
  name,
  type = "text",
  value,
  onChange,
  placeholder,
  error,
  required,
}) {
  const id = name; 

  return (
    <div className="space-y-2">
      {label && (
        <label
          htmlFor={id} 
          className="block text-sm font-medium text-gray-700 tracking-wide"
        >
          {label}
        </label>
      )}

      <input
        id={id} 
        name={name}
        type={type}
        value={value}
        onChange={onChange}
        placeholder={placeholder}
        required={required}
        className={`
          w-full rounded-xl border px-4 py-3 text-base
          font-sans font-normal tracking-wide
          transition-all duration-200 ease-out
          focus:outline-none focus:ring-1 focus:ring-offset-1
          placeholder:text-gray-400
          ${error
            ? "border-[#BF1E2E] bg-gradient-to-r from-[#BF1E2E]/10 to-[#67010F]/10 focus:border-[#BF1E2E] focus:ring-[#BF1E2E]/30"
            : "border-gray-200 bg-white/80 focus:border-[#BF1E2E] focus:ring-[#BF1E2E]/30"
          }
        `}
      />

      {error && (
        <p className="text-sm font-medium text-red-500 flex items-center gap-1.5">
          <span className="w-1.5 h-1.5 bg-red-500 rounded-full" />
          {error}
        </p>
      )}
    </div>
  );
}