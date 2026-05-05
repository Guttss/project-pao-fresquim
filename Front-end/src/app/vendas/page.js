export default function VendasPage() {
  return (
    <div className="p-8">
      <header className="mb-8">
        <h2 className="text-2xl font-bold">Ponto de Venda (PDV)</h2>
        <p className="text-gray-500">
          Inicie uma nova venda escaneando os produtos.
        </p>
      </header>

      <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
        <p className="text-center text-gray-400 py-20 italic">
          Nenhum item adicionado ainda...
        </p>
      </div>
    </div>
  );
}
