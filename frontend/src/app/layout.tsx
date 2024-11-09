'use client'
import localFont from "next/font/local";
import "@/styles/globals.css";
import Navbar from "@/components/Navbar/Navbar";
import Footer from "@/components/Footer/Footer";
import { usePathname } from "next/navigation";

const geistSans = localFont({
  src: "./fonts/GeistVF.woff",
  variable: "--font-geist-sans",
  weight: "100 900",
});
const geistMono = localFont({
  src: "./fonts/GeistMonoVF.woff",
  variable: "--font-geist-mono",
  weight: "100 900",
});


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
    const hiddenPaths = ['/login', '/signup']
    const pathname = usePathname();
  return (
   <html lang="en">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <body className={`${geistSans.variable} ${geistMono.variable}`}>
    <main>
     {/* Renderiza el Navbar solo si no estamos en la página de login */}
     {!hiddenPaths.includes(pathname) && <Navbar />}
     {children}
     <Footer/>
    </main>
    </body>
   </html>
  );
}
