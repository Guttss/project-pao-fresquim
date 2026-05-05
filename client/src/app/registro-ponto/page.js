"use client";

import { useState, useEffect } from "react";
import { Clock } from "lucide-react";

export default function RegistroPontoPage() {
  const [tempo, setTempo] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => setTempo(new Date()), 1000);
    return () => clearInterval(timer);
  }, []);

  const historico = [];

  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      {/* Cabeçalho */}
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Registro de Ponto</h1>
        <p className="text-gray-500">Controle de horários</p>
      </div>

      <div className="max-w-4xl mx-auto space-y-6">
        {/* Card de Registro Principal */}
        <div className="bg-white p-10 rounded-2xl shadow-sm border border-gray-100 text-center">
          <div className="flex items-center justify-center gap-2 text-gray-500 mb-4">
            <Clock size={20} />
            <span className="font-medium">Registrar Ponto</span>
          </div>

          <div className="mb-8">
            <h2 className="text-6xl font-black text-gray-800 tracking-tight">
              {tempo.toLocaleTimeString("pt-BR")}
            </h2>
            <p className="text-gray-400 mt-2 capitalize">
              {tempo.toLocaleDateString("pt-BR", {
                weekday: "long",
                day: "numeric",
                month: "long",
                year: "numeric",
              })}
            </p>
          </div>

          {/* Botões de Ação */}
          <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
            <button className="bg-emerald-600 hover:bg-emerald-700 text-white py-3 rounded-xl font-bold transition-all shadow-md shadow-emerald-100">
              Entrada
            </button>
            <button className="bg-orange-500 hover:bg-orange-600 text-white py-3 rounded-xl font-bold transition-all shadow-md shadow-orange-100">
              Saída Almoço
            </button>
            <button className="bg-blue-600 hover:bg-blue-700 text-white py-3 rounded-xl font-bold transition-all shadow-md shadow-blue-100">
              Volta Almoço
            </button>
            <button className="bg-red-600 hover:bg-red-700 text-white py-3 rounded-xl font-bold transition-all shadow-md shadow-red-100">
              Saída
            </button>
          </div>
        </div>

        {/* Tabela de Histórico*/}
        <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
          <div className="p-6 border-b border-gray-50">
            <h3 className="font-bold text-gray-800">Histórico de Registros</h3>
          </div>

          <table className="w-full text-left">
            <thead className="bg-gray-50/50 text-[11px] uppercase text-gray-400 font-semibold">
              <tr>
                <th className="px-8 py-4">Data</th>
                <th className="px-8 py-4 text-center">Tipo</th>
                <th className="px-8 py-4 text-right">Horário</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-50 text-sm">
              {historico.map((item, index) => (
                <tr
                  key={index}
                  className="hover:bg-gray-50/50 transition-colors"
                >
                  <td className="px-8 py-4 text-gray-600 font-medium">
                    {item.data}
                  </td>
                  <td className="px-8 py-4 text-center">
                    <span
                      className={`px-4 py-1 rounded-full text-[10px] font-bold uppercase ${item.cor}`}
                    >
                      {item.tipo}
                    </span>
                  </td>
                  <td className="px-8 py-4 text-right text-gray-800 font-bold">
                    {item.horario}
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
