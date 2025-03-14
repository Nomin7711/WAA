import axios from 'axios';
import React, { useRef } from 'react'
import { useNavigate } from 'react-router';

const Login = () => {
    const formRef = useRef();
    const navigate = useNavigate();
    const handleSubmit = (event) => {
        event.preventDefault();
        const form = formRef.current;
        const data = {
            name: form.username.value,
            password: form.password.value
        }
        console.log(data);
        
        axios.post('http://localhost:8080/authenticate', data).then(res => {            
            localStorage.setItem('isLoggedIn', res?.data?.name);
            if(res?.data != ""){
                navigate('/posts');
            }else{
                localStorage.setItem('isLoggedIn', false);
                alert("Invalid username or password");
            }
        }).catch(err => {
            console.log(err);
        })
    }
  return (
    <div className='login'>
        <h1>Login</h1>
        <br/>
        <form ref={formRef}>
            <div>
                <label>Username : </label>
                <input type="text" id="username" name="username" className='input' placeholder='admin'/>
            </div>
            <div>
                <label>Password : </label>
                <input type="password" id="password" name="password" className='input' placeholder='123'/>
            </div>
            
            <button type="submit" onClick={handleSubmit} className='button'>Login</button>
        </form>
    </div>
  )
}

export default Login;