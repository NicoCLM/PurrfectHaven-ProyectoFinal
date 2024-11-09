'use client'
import AuthForm from "@/components/Form/Form";
export default function SignUp () {
    return(
        <div>
            <h1>Registrarse</h1>
            <AuthForm isRegister={true}/>
        </div>

    );
}
