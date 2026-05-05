"use client";

import { useState, useEffect } from "react";
import { Search, Plus, Edit2, Trash2, UserPlus } from "lucide-react";

export default function ClientesPage() {
  const [clientes, setClientes] = useState([]);
  const [busca, setBusca] = useState("");

  useEffect(() => {
    const dadosMockados = [
      {
        id: 1,
        nome: "Maria Silva",
        endereco: "Rua das Flores, 123",
        cpf: "123.456.789-00",
        telefone: "(11) 98765-4321",
        email: "maria.silva@email.com",
        serasa: "Positivo",
        totalCompras: 1250.5,
      },
    ];
    setClientes(dadosMockados);
  }, []);

  // Lógica de filtro para a barra de busca
  const clientesFiltrados = clientes.filter(
    (cliente) =>
      cliente.nome.toLowerCase().includes(busca.toLowerCase()) ||
      cliente.cpf.includes(busca),
  );

  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      {/* Header da Tela */}
      <div className="flex justify-between items-start mb-8">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Clientes</h1>
          <p className="text-gray-500">Gerencie o cadastro de clientes</p>
        </div>
        <button className="bg-orange-600 hover:bg-orange-700 text-white px-4 py-2 rounded-lg flex items-center gap-2 transition-all font-medium shadow-sm">
          <Plus size={20} />
          Novo Cliente
        </button>
      </div>

      {/* Card Principal */}
      <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
        {/* Barra de Busca */}
        <div className="p-6 border-b border-gray-50">
          <div className="relative max-w-4xl">
            <Search
              className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
              size={18}
            />
            <input
              type="text"
              placeholder="Buscar por nome, CPF ou telefone..."
              className="w-full pl-10 pr-4 py-2.5 bg-gray-100 border-none rounded-xl focus:ring-2 focus:ring-orange-500 outline-none text-sm transition-all"
              value={busca}
              onChange={(e) => setBusca(e.target.value)}
            />
          </div>
        </div>

        {/* Tabela de Clientes */}
        <div className="overflow-x-auto">
          <table className="w-full text-left">
            <thead className="bg-gray-50/50">
              <tr className="text-gray-400 text-[11px] uppercase tracking-wider font-semibold">
                <th className="px-6 py-4">Nome</th>
                <th className="px-6 py-4">CPF</th>
                <th className="px-6 py-4">Telefone</th>
                <th className="px-6 py-4">E-mail</th>
                <th className="px-6 py-4 text-center">Serasa</th>
                <th className="px-6 py-4">Total Compras</th>
                <th className="px-6 py-4 text-right">Ações</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-50 text-sm">
              {clientesFiltrados.map((cliente) => (
                <tr
                  key={cliente.id}
                  className="hover:bg-gray-50/50 transition-colors"
                >
                  <td className="px-6 py-4">
                    <p className="font-bold text-gray-800">{cliente.nome}</p>
                    <p className="text-xs text-gray-400">{cliente.endereco}</p>
                  </td>
                  <td className="px-6 py-4 text-gray-600">{cliente.cpf}</td>
                  <td className="px-6 py-4 text-gray-600">
                    {cliente.telefone}
                  </td>
                  <td className="px-6 py-4 text-gray-600">{cliente.email}</td>
                  <td className="px-6 py-4 text-center">
                    <span
                      className={`px-3 py-1 rounded-full text-[10px] font-bold uppercase ${
                        cliente.serasa === "Positivo"
                          ? "bg-emerald-100 text-emerald-600"
                          : "bg-red-100 text-red-600"
                      }`}
                    >
                      {cliente.serasa}
                    </span>
                  </td>
                  <td className="px-6 py-4 font-bold text-emerald-600">
                    R${" "}
                    {cliente.totalCompras.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 text-right">
                    <div className="flex justify-end gap-2">
                      <button className="p-2 text-blue-500 hover:bg-blue-50 rounded-lg transition-colors">
                        <Edit2 size={16} />
                      </button>
                      <button className="p-2 text-red-500 hover:bg-red-50 rounded-lg transition-colors">
                        <Trash2 size={16} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          {clientesFiltrados.length === 0 && (
            <div className="p-20 text-center text-gray-400">
              Nenhum cliente encontrado para sua busca.
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
