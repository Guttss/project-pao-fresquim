"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import {
  ShoppingCart,
  Package,
  Users,
  UserCog,
  BarChart3,
  Clock,
  Camera,
  LogOut,
} from "lucide-react";

const menuItems = [
  { name: "Vendas", icon: ShoppingCart, href: "/vendas" },
  { name: "Produtos", icon: Package, href: "/produtos" },
  { name: "Clientes", icon: Users, href: "/clientes" },
  { name: "Funcionários", icon: UserCog, href: "/funcionarios" },
  { name: "Relatórios", icon: BarChart3, href: "/relatorios" },
  { name: "Registro de Ponto", icon: Clock, href: "/registro-ponto" },
  { name: "Câmeras", icon: Camera, href: "/cameras" },
];

export default function Sidebar() {
  const pathname = usePathname();

  return (
    <aside className="w-64 h-screen bg-white border-r border-gray-200 flex flex-col fixed left-0 top-0">
      {}
      <div className="p-6">
        <h1 className="text-xl font-bold text-orange-600">Padaria System</h1>
        <p className="text-xs text-gray-500 font-medium uppercase tracking-wider">
          Gestão de Vendas
        </p>
      </div>

      <nav className="flex-1 px-4 space-y-1">
        {menuItems.map((item) => {
          const isActive = pathname === item.href;
          return (
            <Link
              key={item.name}
              href={item.href}
              className={`flex items-center gap-3 px-4 py-3 rounded-lg transition-all ${
                isActive
                  ? "bg-orange-50 text-orange-600 font-semibold"
                  : "text-gray-600 hover:bg-gray-100"
              }`}
            >
              <item.icon size={30} />
              <span>{item.name}</span>
            </Link>
          );
        })}
      </nav>

      {/* Perfil do Admin */}
      <div className="p-4 border-t border-gray-100">
        <div className="flex items-center gap-3 p-2 bg-gray-50 rounded-xl">
          <div className="w-10 h-10 bg-orange-500 rounded-full flex items-center justify-center text-white font-bold">
            A
          </div>
          <div className="flex-1">
            <p className="text-sm font-bold text-gray-800">Admin</p>
            <p className="text-xs text-gray-500">Gerente</p>
          </div>
          <button className="text-gray-400 hover:text-red-500">
            <LogOut size={18} />
          </button>
        </div>
      </div>
    </aside>
  );
}
