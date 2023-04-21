
import { createContext, useContext, useState } from "react";

export const AuthContext =  createContext()

export const useAuth = () => useContext(AuthContext) 

//onst authContext = useContext(AuthContext)

export default function AuthProvider({children}){

    const [number,setNumber] = useState(10)

    const [isAuthenticated, setAuthenticated] = useState(false)


    function login(username, password){
        if(username==='taran' && password === 'password'){
            setAuthenticated(true)
            return true
            
        }else{
            setAuthenticated(false)
            return false
        }
        
    }

    function logout(){
        setAuthenticated(false)
    }

    setInterval(
        () => setNumber(number+1,
            1000)
    )

    //const valueToBeShared = {number, isAuthenticated, SetAuthenticated}

    return(
        <AuthContext.Provider value={{number, isAuthenticated, setAuthenticated, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}