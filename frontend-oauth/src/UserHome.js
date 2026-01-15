import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "./AuthContext";
import LogoutButton from "./LogoutButton";

export default function UserHome() {
  const navigate = useNavigate();
  const { user } = useContext(AuthContext);

  if (!user) return null; // PrivateRoute handles redirect

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Welcome {user.name}!</h1>
      <button onClick={() => navigate("/profile")}>Go to Profile</button>
      <br /><br />
      <LogoutButton />
    </div>
  );
}
