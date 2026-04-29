const columna1 = document.getElementById("columna1")
const columna2 = document.getElementById("columna2")
const columna3 = document.getElementById("columna3")
document.getElementById("enviar").addEventListener("click",crearTarea);
let contador1 = 0;
let contador2 = 0;
let contador3 = 0;
const demo = document.getElementById("demo")



function crearTarea(e){
    e.preventDefault();

    let texto = document.getElementById("textoTarea").value;
    let estado = document.getElementById("opcion").value;

    let card = document.createElement('div')
        card.classList.add('tarjeta')

        card.innerHTML = `
            <p>TAREA</P>
            <p>${texto}</p>
            <button class="btn_proceso">EN PROCESO</button>
            <button class="btn_finalizado">FINALIZADO</button>
            <button class="btn_eliminar">ELIMINAR</button>
        
        `;

        let btn_proceso = card.querySelector(".btn_proceso");
        let btn_finalizado = card.querySelector(".btn_finalizado");
        let btn_eliminar = card.querySelector(".btn_eliminar");


        if (estado === "pendiente"){

            columna1.appendChild(card)
        }


        if (estado === "en-proceso"){

            columna2.appendChild(card)
        }

        if (estado === "finalizado"){

            columna3.appendChild(card)
        }

        btn_proceso.addEventListener("click",() => {
        columna2.appendChild(card)
        })

        btn_finalizado.addEventListener("click",() => {
        columna3.appendChild(card)
        })

        btn_eliminar.addEventListener("click",() => {
        card.remove();
        })

    const input = document.getElementById("textoTarea").value = ""

    

}



