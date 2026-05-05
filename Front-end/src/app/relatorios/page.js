"use client";

import {
  DollarSign,
  Package,
  TrendingUp,
  Users,
  Calendar,
  ChevronDown,
} from "lucide-react";

export default function RelatoriosPage() {
  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      <div className="flex justify-between items-center mb-8">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Relatórios</h1>
          <p className="text-gray-500">Resumo de vendas e desempenho</p>
        </div>
        <button className="flex items-center gap-2 px-4 py-2 bg-white border border-gray-200 rounded-lg text-sm font-medium text-gray-600 hover:bg-gray-50 transition-all shadow-sm">
          Esta Semana
          <ChevronDown size={16} />
        </button>
      </div>
    </div>
  );
}
