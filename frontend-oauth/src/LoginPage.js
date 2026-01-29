import React, { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "./AuthContext";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const { setUser } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const res = await fetch("http://localhost:2026/auth/login", {
        method: "POST",
        credentials: "include",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      const data = await res.json();

      if (!res.ok) {
        setMessage(data.message || "Login failed");
        return;
      }

       // Only store user info in context, not the token
      setUser({ id: data.id, name: data.name, email: data.email });

     // setUser(data); // update global user state
      navigate("/user/home");
    } catch (err) {
      console.error(err);
      setMessage("Login failed");
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h2>Login</h2>

      <input type="email" placeholder="Email" onChange={e => setEmail(e.target.value)} /><br /><br />
      <input type="password" placeholder="Password" onChange={e => setPassword(e.target.value)} /><br /><br />

      <button onClick={handleLogin}>Login</button>

      {message && <p>{message}</p>}
    </div>
  );
}
