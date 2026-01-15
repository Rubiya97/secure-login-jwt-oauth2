import React, { useContext } from "react";
import { AuthContext } from "./AuthContext";

export default function LogoutButton() {
  const { setUser } = useContext(AuthContext);

  const handleLogout = async () => {
    try {
      await fetch("http://localhost:8080/auth/logout", {
        method: "POST",
        credentials: "include",
      });
      setUser(null); // clear context → redirects handled by PrivateRoute
    } catch (err) {
      console.error("Logout error:", err);
    }
  };

  return <button onClick={handleLogout}>Logout</button>;
}
