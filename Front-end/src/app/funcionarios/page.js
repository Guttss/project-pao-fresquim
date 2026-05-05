"use client";

import { useState, useEffect } from "react";
import { Search, Plus, Edit2, Trash2, UserCog } from "lucide-react";

export default function FuncionariosPage() {
  // Estado para armazenar os dados dos funcionários
  const [funcionarios, setFuncionarios] = useState([]);
  const [busca, setBusca] = useState("");

  // Dados baseados no arquivo Prototipo.pdf
  useEffect(() => {
    const dadosFuncionarios = [
      {
        id: 1,
        nome: "Carlos Souza",
        email: "carlos.souza@padaria.com",
        cpf: "111.222.333-44",
        cargo: "Padeiro",
        telefone: "(11) 99999-1111",
        salario: 2500.0,
        status: "Ativo",
      },
    ];
    setFuncionarios(dadosFuncionarios);
  }, []);

  // Lógica de filtro por nome, CPF ou cargo
  const funcionariosFiltrados = funcionarios.filter(
    (f) =>
      f.nome.toLowerCase().includes(busca.toLowerCase()) ||
      f.cpf.includes(busca) ||
      f.cargo.toLowerCase().includes(busca.toLowerCase()),
  );

  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      {/* Cabeçalho da página */}
      <div className="flex justify-between items-start mb-8">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Funcionários</h1>
          <p className="text-gray-500">Gerencie o cadastro de funcionários</p>
        </div>
        <button className="bg-orange-600 hover:bg-orange-700 text-white px-4 py-2 rounded-lg flex items-center gap-2 transition-all font-medium shadow-sm">
          <Plus size={20} />
          Novo Funcionário
        </button>
      </div>

      {/* Container da Tabela */}
      <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
        {/* Campo de Busca[cite: 1] */}
        <div className="p-6 border-b border-gray-50">
          <div className="relative max-w-full">
            <Search
              className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
              size={18}
            />
            <input
              type="text"
              placeholder="Buscar por nome, CPF ou cargo..."
              className="w-full pl-10 pr-4 py-2.5 bg-gray-100 border-none rounded-xl focus:ring-2 focus:ring-orange-500 outline-none text-sm transition-all"
              value={busca}
              onChange={(e) => setBusca(e.target.value)}
            />
          </div>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left">
            <thead className="bg-gray-50/50">
              <tr className="text-gray-400 text-[11px] uppercase tracking-wider font-semibold">
                <th className="px-6 py-4">Nome</th>
                <th className="px-6 py-4">CPF</th>
                <th className="px-6 py-4">Cargo</th>
                <th className="px-6 py-4">Telefone</th>
                <th className="px-6 py-4">Salário</th>

                <th className="px-6 py-4 text-right">Ações</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-50 text-sm">
              {funcionariosFiltrados.map((func) => (
                <tr
                  key={func.id}
                  className="hover:bg-gray-50/50 transition-colors"
                >
                  <td className="px-6 py-4">
                    <p className="font-bold text-gray-800">{func.nome}</p>
                    <p className="text-xs text-gray-400">{func.email}</p>
                  </td>
                  <td className="px-6 py-4 text-gray-600">{func.cpf}</td>
                  <td className="px-6 py-4">
                    <span className="bg-blue-50px-3 py-1 rounded-lg text-xs font-medium">
                      {func.cargo}
                    </span>
                  </td>
                  <td className="px-6 py-4 text-gray-600">{func.telefone}</td>
                  <td className="px-6 py-4 font-bold text-gray-800">
                    R${" "}
                    {func.salario.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>

                  <td className="px-6 py-4 text-right">
                    <div className="flex justify-end gap-2">
                      <button className="p-2 text-blue-500 hover:bg-blue-50 rounded-lg transition-colors border border-blue-100">
                        <Edit2 size={16} />
                      </button>
                      <button className="p-2 text-red-500 hover:bg-red-50 rounded-lg transition-colors border border-red-100">
                        <Trash2 size={16} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
