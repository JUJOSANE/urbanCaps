import {useState, useEffect} from 'react'

function ListaProductos() {
  const [productos, setProductos] = useState([]);

  const getProductos = async ()=>{
    try{
        const response  = await fetch("http://localhost:8080/productos");

        if(!response.ok) {
            throw new Error("Error inesperado al obtener productos")
        }
        const data = await response.json();
        setProductos(data);
    }catch(error){
        console.error("Error en la peticion GET: " + error)
    }
  };

  useEffect(()=>{
    getProductos();
  },[]);
   
  return(
    <div style={{ padding: 20 }}>
      <h2>Lista de Productos 📦</h2>

      {productos.map((producto) => (
        <div
          key={producto.id}
          style={{
            background: "#1d5167ff",
            padding: 10,
            marginBottom: 10,
            borderRadius: 8,
          }}
        >
          <h3>{producto.nombreProdu}</h3>
          <p>Marca: {producto.marca}</p>
          <p>Precio: ${producto.precio}</p>
          <p>Stock: {producto.stock}</p>
        </div>
      ))}
    </div>
  );
}
export default ListaProductos;
