"use client";

import { useState, useEffect } from "react";
import { Search, Plus, Edit2, Trash2, Package } from "lucide-react";

export default function ProdutosPage() {
  const [produtos, setProdutos] = useState([]);
  const [busca, setBusca] = useState("");

  useEffect(() => {
    const dadosProdutos = [
      {
        id: 1,
        nome: "Pão Francês",
        categoria: "Pães",
        custo: 0.25,
        preco: 0.5,
        estoque: 200,
      },
    ];
    setProdutos(dadosProdutos);
  }, []);

  // Filtro de busca por nome ou categoria
  const produtosFiltrados = produtos.filter(
    (p) =>
      p.nome.toLowerCase().includes(busca.toLowerCase()) ||
      p.categoria.toLowerCase().includes(busca.toLowerCase()),
  );

  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      <div className="flex justify-between items-start mb-8">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Produtos</h1>
          <p className="text-gray-500">Gerencie o catálogo de produtos</p>
        </div>
        <button className="bg-orange-600 hover:bg-orange-700 text-white px-4 py-2 rounded-lg flex items-center gap-2 transition-all font-medium shadow-sm">
          <Plus size={20} />
          Novo Produto
        </button>
      </div>

      {/* Contaiter que lista os produtos */}
      <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
        {/* Barra de Pesquisa */}
        <div className="p-6 border-b border-gray-50">
          <div className="relative max-w-full">
            <Search
              className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
              size={18}
            />
            <input
              type="text"
              placeholder="Buscar produtos..."
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
                <th className="px-6 py-4">Produto</th>
                <th className="px-6 py-4">Categoria</th>
                <th className="px-6 py-4">Custo</th>
                <th className="px-6 py-4">Preço</th>
                <th className="px-6 py-4">Estoque</th>
                <th className="px-6 py-4 text-right">Ações</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-50 text-sm">
              {produtosFiltrados.map((item) => (
                <tr
                  key={item.id}
                  className="hover:bg-gray-50/50 transition-colors"
                >
                  <td className="px-6 py-4 font-bold text-gray-800">
                    {item.nome}
                  </td>
                  <td className="px-6 py-4">
                    <span className="bg-orange-100 text-orange-700 px-3 py-1 rounded-lg text-xs font-medium">
                      {item.categoria}
                    </span>
                  </td>
                  <td className="px-6 py-4 text-gray-600">
                    R${" "}
                    {item.custo.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 font-bold text-gray-800">
                    R${" "}
                    {item.preco.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 text-gray-600 font-medium">
                    {item.estoque}
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
