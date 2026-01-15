import React, { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "./AuthContext";

export default function ProfilePage() {
  const { user, fetchUser } = useContext(AuthContext);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const checkProfile = async () => {
      await fetchUser(); // ensures user data is current
      setLoading(false);
    };
    checkProfile();
  }, [fetchUser]);

  useEffect(() => {
    if (!user && !loading) {
      navigate("/", { replace: true });
    }
  }, [user, loading, navigate]);

  if (loading) return <p>Loading...</p>;
  if (!user) return null;

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Profile</h1>
      <p><b>Name:</b> {user.name}</p>
      <p><b>Email:</b> {user.email}</p>
      <p><b>User ID:</b> {user.id}</p>
    </div>
  );
}

