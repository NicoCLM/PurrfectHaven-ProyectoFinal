'use client'
import AuthForm from "@/components/Form/Form";
export default function Login (){
    return (
        <div>
            <h1>Iniciar sesión</h1>
            <AuthForm isRegister={false}/>
        </div>
    );
}
