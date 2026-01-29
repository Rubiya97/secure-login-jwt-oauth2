import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "./AuthContext";

export default function HomePage() {
  const navigate = useNavigate();
  const { user } = useContext(AuthContext);

  const handleGoogleLogin = () => {
    window.location.href = "http://localhost:2026/oauth2/authorization/google";
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Welcome to My App</h1>

      {!user && (
        <>
          <button onClick={() => navigate("/login")}>Login</button>
          <br /><br />
          <button onClick={() => navigate("/register")}>Register</button>
          <br /><br />
          <button onClick={handleGoogleLogin}>Login with Google</button>
        </>
      )}

      {user && (
        <>
          <p>Hello, {user.name}!</p>
          <button onClick={() => navigate("/user/home")}>Go to Dashboard</button>
        </>
      )}
    </div>
  );
}
