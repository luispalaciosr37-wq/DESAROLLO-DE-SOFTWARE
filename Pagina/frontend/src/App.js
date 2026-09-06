import { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [productos, setProductos] = useState([]);
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
  
    axios.get("http://localhost:8080/api/productos")
      .then(res => setProductos(res.data))
      .catch(err => console.error(err));

  
    axios.get("http://localhost:8080/api/categorias")
      .then(res => setCategorias(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Mi Tienda de Cosméticos</h1>

      <h2>Categorías</h2>
      <ul>
        {categorias.map(cat => (
          <li key={cat.id}>{cat.nombre}</li>
        ))}
      </ul>

      <h2>Productos</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Categoría</th>
          </tr>
        </thead>
        <tbody>
          {productos.map(prod => (
            <tr key={prod.id}>
              <td>{prod.nombre}</td>
              <td>${prod.precio}</td>
              <td>{prod.categoria?.nombre || "Sin categoría"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
