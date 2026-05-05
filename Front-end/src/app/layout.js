import "./globals.css";
import Sidebar from "@/components/Sidebar";

export const metadata = {
  title: "Padaria System - Gestão de Vendas",
  description: "Sistema interno da Padaria Pão FresQUIM",
};

export default function RootLayout({ children }) {
  return (
    <html lang="pt-br">
      <body className="bg-gray-50 text-gray-900">
        <div className="flex">
          <Sidebar />

          <main className="flex-1 ml-64 min-h-screen">{children}</main>
        </div>
      </body>
    </html>
  );
}
