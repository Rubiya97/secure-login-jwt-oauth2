import { useContext } from "react";
import { Navigate } from "react-router-dom";
import { AuthContext } from "./AuthContext";

const PrivateRoute = ({ element }) => {
  const { user, loading } = useContext(AuthContext);

  if (loading) return <p>Loading...</p>; // wait for auth check
  return user ? element : <Navigate to="/" replace />;
};

export default PrivateRoute;
