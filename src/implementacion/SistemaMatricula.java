package implementacion;


import clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SistemaMatricula {
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Curso> cursosInscritos = new ArrayList<>();
    private static Estudiante estudianteActual;
    private static List<Ciclo> ciclos = new ArrayList<>();



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cargarCiclosYCursos();

        boolean salir = false;
        while (!salir) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1) Ingrese los datos del estudiante");
            System.out.println("2) Ingrese los datos del curso");
            System.out.println("3) Reporte de matrículas");
            System.out.println("4) Imprimir Factura");
            System.out.println("5) Guardar y seguir");
            System.out.println("6) Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    ingresarDatosEstudiante(scanner);
                    break;
                case 2:
                    ingresarDatosCurso(scanner);
                    break;
                case 3:
                    generarReporteMatriculas();
                    break;
                case 4:
                    imprimirFactura();
                    break;
                case 5:
                    guardarEstudiantesEnArchivo();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
        guardarEstudiantesEnArchivo();
// Aquí se puede guardar la información antes de salir
    }


    private static void cargarCiclosYCursos() {
// Ciclo 1
        Ciclo ciclo1 = new Ciclo(1);
        ciclo1.agregarCurso(new Curso("Introduccion a la Matematica para Ingenieros", "PROF001", 3, "3:30pm", "Lun, Mié, Vie", 100.0));
        ciclo1.agregarCurso(new Curso("Ingles", "PROF002", 3, "6:00pm", "Mar, Juv, Sab", 120.0));
        ciclo1.agregarCurso(new Curso("Introduccion al Medio Ambiente", "PROF003", 3, "10:00am", "Dom", 160.0));

        ciclos.add(ciclo1);

// Ciclo 2
        Ciclo ciclo2 = new Ciclo(2);
        ciclo2.agregarCurso(new Curso("Matemáticas para Ingenieros I", "PROF101", 5, "9:00am", "Lun, Mar, Mié, Jue, Vie", 180.0));
        ciclo2.agregarCurso(new Curso("Física", "PROF102", 4, "2:00pm", "Lun, Mié, Vie", 190.0));
        ciclo2.agregarCurso(new Curso("Algoritmos", "PROF103", 4, "3:30pm", "Mar, Jue", 210.0));
        ciclo2.agregarCurso(new Curso("Bases de Datos", "PROF104", 4, "6:00pm", "Mar, Jue", 200.0));
        ciclos.add(ciclo2);

// Ciclo 3
        Ciclo ciclo3 = new Ciclo(3);
        ciclo3.agregarCurso(new Curso("Inteligencia Artificial", "PROF201", 4, "2:00pm", "Lun, Mié", 220.0));
        ciclo3.agregarCurso(new Curso("Programación Avanzada", "PROF202", 4, "3:30pm", "Mar, Jue", 210.0));
        ciclo3.agregarCurso(new Curso("Redes de Computadoras", "PROF203", 4, "6:00pm", "Mar, Jue", 200.0));
        ciclos.add(ciclo3);

// Ciclo 4
        Ciclo ciclo4 = new Ciclo(4);
        ciclo4.agregarCurso(new Curso("Redes de Computadoras", "PROF015", 4, "8:00am", "Lun, Mié", 200.0));
        ciclo4.agregarCurso(new Curso("Programación en Java", "PROF016", 4, "10:00am", "Mar, Jue", 210.0));
        ciclo4.agregarCurso(new Curso("Sistemas Operativos", "PROF017", 4, "3:00pm", "Mar, Jue", 190.0));
        ciclo4.agregarCurso(new Curso("Bases de Datos Avanzadas", "PROF018", 4, "4:30pm", "Lun, Mié", 220.0));
        ciclos.add(ciclo4);

// Ciclo 5
        Ciclo ciclo5 = new Ciclo(5);
        ciclo5.agregarCurso(new Curso("Introducción a la Ingeniería de Sistemas", "PROF019", 3, "8:00am", "Mar, Jue", 160.0));
        ciclo5.agregarCurso(new Curso("Estructura de Datos", "PROF020", 4, "10:00am", "Lun, Mié", 200.0));
        ciclo5.agregarCurso(new Curso("Programación en Python", "PROF021", 4, "3:00pm", "Mar, Jue", 210.0));
        ciclo5.agregarCurso(new Curso("Probabilidad y Estadística", "PROF022", 4, "4:30pm", "Lun, Mié", 180.0));
        ciclos.add(ciclo5);

// Ciclo 6
        Ciclo ciclo6 = new Ciclo(6);
        ciclo6.agregarCurso(new Curso("Diseño de Algoritmos", "PROF023", 4, "8:00am", "Mar, Jue", 210.0));
        ciclo6.agregarCurso(new Curso("Teoría de la Computación", "PROF024", 4, "10:00am", "Lun, Mié", 190.0));
        ciclo6.agregarCurso(new Curso("Sistemas Distribuidos", "PROF025", 4, "3:00pm", "Mar, Jue", 220.0));
        ciclo6.agregarCurso(new Curso("Gestión de Proyectos de Software", "PROF026", 3, "4:30pm", "Lun, Mié", 180.0));
        ciclos.add(ciclo6);

// Ciclo 7
        Ciclo ciclo7 = new Ciclo(7);
        ciclo7.agregarCurso(new Curso("Introducción a la Inteligencia Artificial", "PROF027", 3, "8:00am", "Mar, Jue", 190.0));
        ciclo7.agregarCurso(new Curso("Desarrollo de Aplicaciones Móviles", "PROF028", 4, "10:00am", "Lun, Mié", 210.0));
        ciclo7.agregarCurso(new Curso("Seguridad Informática", "PROF029", 4, "3:00pm", "Mar, Jue", 220.0));
        ciclo7.agregarCurso(new Curso("Ética y Responsabilidad Profesional", "PROF030", 3, "4:30pm", "Lun, Mié", 160.0));
        ciclos.add(ciclo7);

// Ciclo 8
        Ciclo ciclo8 = new Ciclo(8);
        ciclo8.agregarCurso(new Curso("Sistemas de Información", "PROF031", 4, "8:00am", "Mar, Jue", 200.0));
        ciclo8.agregarCurso(new Curso("Análisis y Diseño de Sistemas", "PROF032", 4, "10:00am", "Lun, Mié", 210.0));
        ciclo8.agregarCurso(new Curso("Big Data", "PROF033", 4, "3:00pm", "Mar, Jue", 220.0));
        ciclo8.agregarCurso(new Curso("Gestión de Calidad del Software", "PROF034", 3, "4:30pm", "Lun, Mié", 190.0));
        ciclos.add(ciclo8);

// Ciclo 9
        Ciclo ciclo9 = new Ciclo(9);
        ciclo9.agregarCurso(new Curso("Inteligencia Artificial", "PROF027", 5, "8:00am", "Lun, Mié", 230.0));
        ciclo9.agregarCurso(new Curso("Inteligencia Artificial", "PROF028", 5, "3:00pm", "Mar, Jue", 230.0));
        ciclo9.agregarCurso(new Curso("Diseño de Software", "PROF029", 4, "9:00am", "Mar, Jue", 200.0));
        ciclo9.agregarCurso(new Curso("Diseño de Software", "PROF030", 4, "2:00pm", "Lun, Mié", 200.0));
        ciclos.add(ciclo9);

// Ciclo 10
        Ciclo ciclo10 = new Ciclo(10);
        ciclo10.agregarCurso(new Curso("Proyecto Final", "PROF031", 6, "8:00am", "Vie", 300.0));
        ciclo10.agregarCurso(new Curso("Proyecto Final", "PROF032", 6, "2:00pm", "Jue", 300.0));
        ciclo10.agregarCurso(new Curso("Electiva", "PROF033", 3, "9:00am", "Lun, Mié", 150.0));
        ciclo10.agregarCurso(new Curso("Electiva", "PROF034", 3, "4:00pm", "Mar, Jue", 150.0));
        ciclos.add(ciclo10);
// Puedes continuar agregando más ciclos y cursos aquí
    }



    private static void ingresarDatosEstudiante(Scanner scanner) {
        System.out.println("----- Ingrese los datos del estudiante -----");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada


        try {
            System.out.print("Ciclo: ");
            int ciclo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            System.out.print("Código: ");
            String codigo = scanner.nextLine(); // Leer el código del estudiante
            Estudiante nuevoEstudiante = new Estudiante(nombre, dni, direccion, edad, sexo, codigo, ciclo);

            nuevoEstudiante.setCiclo(ciclo); // Establecer el valor del ciclo después de crear el objeto
            estudiantes.add(nuevoEstudiante);
            estudianteActual = nuevoEstudiante; // Asignar el nuevo estudiante como estudiante actual
            System.out.println("Estudiante agregado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static String obtenerSufijoCiclo(int ciclo) {
        String sufijo;
        if (ciclo == 1) {
            sufijo = "1°";
        } else if (ciclo == 2) {
            sufijo = "2°";
        } else if (ciclo == 3) {
            sufijo = "3°";
        } else {
            sufijo = ciclo + "°";
        }
        return sufijo;
    }


    private static void ingresarDatosCurso(Scanner scanner) {
        System.out.println("----- Ingrese los datos del curso -----");
        System.out.println("Lista de ciclos:");
        for (int i = 0; i < ciclos.size(); i++) {
            System.out.println((i + 1) + ") Ciclo " + ciclos.get(i).getNumero());
        }

        System.out.print("Seleccione el número del ciclo: ");
        int numeroCiclo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        if (numeroCiclo >= 1 && numeroCiclo <= ciclos.size()) {
            List<Curso> cursosCicloSeleccionado = ciclos.get(numeroCiclo - 1).getCursos();
            System.out.println("Cursos disponibles para el Ciclo " + numeroCiclo + ":");
            for (int i = 0; i < cursosCicloSeleccionado.size(); i++) {
                Curso curso = cursosCicloSeleccionado.get(i);
                System.out.println((i + 1) + ") " + curso.getNombre() + " - Código: " + curso.getCodigo() +
                        " - Créditos: " + curso.getCreditos() + " - Días: " + curso.getDias() +
                        " - Profesores: " + curso.getProfesoresAsString() + " - Precio: " + curso.getPrecio());
            }

            System.out.print("Seleccione el número del curso: ");
            int numeroCurso = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            if (numeroCurso >= 1 && numeroCurso <= cursosCicloSeleccionado.size()) {
                Curso cursoSeleccionado = cursosCicloSeleccionado.get(numeroCurso - 1);
                estudianteActual.inscribirCurso(cursoSeleccionado);
                System.out.println("El curso '" + cursoSeleccionado.getNombre() + "' ha sido inscrito.");
            } else {
                System.out.println("Número de curso inválido. Por favor, seleccione un número válido.");
            }
        } else {
            System.out.println("Número de ciclo inválido. Por favor, seleccione un número válido.");
        }
    }



    private static void generarReporteMatriculas() {
        System.out.println("----- Reporte de Matrículas -----");
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            System.out.println("Estudiante " + (i + 1) + ":");
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("DNI: " + estudiante.getDni());
            System.out.println("Dirección: " + estudiante.getDireccion());


            System.out.println("Cursos inscritos:");
            List<Curso> cursosInscritosEstudiante = estudiante.getCursosInscritos();
            for (Curso curso : cursosInscritosEstudiante) {
                System.out.println("- " + curso.getNombre() + " - Precio: " + curso.getPrecio());
            }


            System.out.println();
        }

    }
    private static void guardarEstudiantesEnArchivo() {
        File archivo = new File("C:\\Users\\Andre\\OneDrive\\Escritorio\\Estudiantes_Matriculados_segundo_ciclo.txt");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante estudiante : estudiantes) {
                escritor.write("Nombre: " + estudiante.getNombre());
                escritor.newLine();
                escritor.write("DNI: " + estudiante.getDni());
                escritor.newLine();
                escritor.write("Dirección: " + estudiante.getDireccion());
                escritor.newLine();
                escritor.write("Sexo: " + estudiante.getSexo());
                escritor.newLine();
                escritor.write("Edad: " + estudiante.getEdad());
                escritor.newLine();
                escritor.write("Ciclo: " + Integer.toString(estudiante.getCiclo()));
                escritor.newLine();
                escritor.write("Cursos inscritos:");
                escritor.newLine();
                List<Curso> cursosInscritosEstudiante = estudiante.getCursosInscritos();
                for (Curso curso : cursosInscritosEstudiante) {
                    escritor.write("- " + curso.getNombre() + " - Créditos: " + curso.getCreditos() + " - Precio: " + curso.getPrecio());
                    escritor.newLine();
                }
                escritor.newLine();
            }
            System.out.println("La información de los estudiantes ha sido guardada en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar la información en el archivo: " + e.getMessage());
        }
    }




    private static void imprimirFactura() {
        if (estudianteActual != null) {
            Factura factura = new Factura(estudianteActual, cursosInscritos);
            factura.imprimirFactura();
        } else {
            System.out.println("No hay un estudiante seleccionado.");
        }


        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mma");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        String currentTime = hourFormat.format(date);

        System.out.println(" Fecha: " + currentDate);
        System.out.println(" UTP Hora: " + currentTime);
        System.out.println();
        System.out.println("----------------------------------------------- Ficha de Matricula 2023 -1 ------------------------------------------");
        System.out.println("Nombre del estudiante: | " + estudianteActual.getNombre() + " | DNI: " + estudianteActual.getDni());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Sede: Universidad Tecnologica del Peru - Arequipa | Programa: TIC783 ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Facultad/Escuela: Ing. de Sistemas e Informatica | Codigo de estudiante: " + estudianteActual.getCodigo() + " ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        String sufijoCiclo = obtenerSufijoCiclo(estudianteActual.getCiclo());
        System.out.println("El departamento de Registro deja constancia que el (la) Sr. " + estudianteActual.getNombre() +
                " con código " + estudianteActual.getCodigo() + " ha registrado matrícula \n en el " + sufijoCiclo + " ciclo de acuerdo al detalle que a continuación se indica.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s%n", "Codigo", "Cursos", "Créditos", "Vez", "Precio");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (Curso curso : cursosInscritos) {
            System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s%n",
                    curso.getCodigo(), curso.getNombre(), curso.getCreditos(), "1", curso.getPrecio());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");


        double totalPago = 0.0;
        List<Curso> cursosInscritos = estudianteActual.getCursosInscritos();
        for (Curso curso : cursosInscritos) {
            System.out.println(" " + curso.getCodigo() + " | " + curso.getNombre() + " | " + curso.getCreditos() + " | 1 | " + curso.getPrecio() + " | ");
            totalPago += curso.getPrecio();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-80s%s%n", "Total a pagar:", totalPago);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Resumen:");
        System.out.printf("%-39s%d%n", "Total de Cursos Matriculados:", cursosInscritos.size());
        System.out.printf("%-39s%.1f%n", "Total de Creditos:", obtenerTotalCreditos(cursosInscritos));
    }


    private static double obtenerTotalCreditos(List<Curso> cursos) {
        int totalCreditos = 0;
        for (Curso curso : cursos) {
            totalCreditos += curso.getCreditos();
        }
        return totalCreditos;
    }
    public static List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }
}
