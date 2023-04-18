import { useState } from 'react'
import {BrowserRouter, Route, Routes, useNavigate, useParams} from 'react-router-dom'
import './TodoApp.css'


export default function TodoApp(){
    return (
        <div className="TodoApp">

            
            <BrowserRouter>
                <Routes>
                <Route path='/' element={<LoginComponent />}></Route>
                    <Route path='/login' element={<LoginComponent />}></Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent />}></Route>
                    <Route path='/*' element={<ErrorComponent />}></Route>
                </Routes>
            </BrowserRouter>
            
        
            {/* <WelcomeComponent /> */}
        </div>
    )
}


function LoginComponent(){

    const [username,setUsername] = useState('taran')

    const [password, setPassword] = useState('')

    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)

    const navigate = useNavigate();

    function handleUsernameChange(event){
        setUsername(event.target.value)
    }

    function handlePasswordChange(event){
        setPassword(event.target.value)
    }

    function handleSubmit(){
        if(username==='taran' && password === 'password'){
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
        }else{
            setShowErrorMessage(true)
            setShowSuccessMessage(false)
        }
        

    }

   

    return (
        <div className="Login">
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
            {showErrorMessage && <div className="errorMessage">Authenticated Failed. Please check your credentials.</div>}
            
            <div className="LoginForm">
                <div>
                    <label>User Name:</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button> 
                </div>
            </div>
        </div>
    )
}



function WelcomeComponent(){

    const {username} = useParams()

    

    return(
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>Welcome Component</div>
        </div>
    )
}


function ErrorComponent(){
    return(
        <div className="ErrorComponent">
            <h1>We are working hard</h1>
            <div>
                Reach out to our team.
            </div>
        </div>
    )
}