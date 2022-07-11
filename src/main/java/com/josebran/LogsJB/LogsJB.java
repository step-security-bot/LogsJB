/***
 * Copyright (C) 2022 El proyecto de código abierto LogsJB de José Bran
 *
 * Con licencia de Apache License, Versión 2.0 (la "Licencia");
 * no puede usar este archivo excepto de conformidad con la Licencia.
 * Puede obtener una copia de la Licencia en
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo exija la ley aplicable o se acuerde por escrito, el software
 * distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulte la Licencia para conocer el idioma específico que rige los permisos y
 * limitaciones bajo la Licencia.
 */

package com.josebran.LogsJB;


import com.josebran.LogsJB.Executores.MensajeWrite;
import com.josebran.LogsJB.Numeracion.NivelLog;
import com.josebran.LogsJB.Numeracion.SizeLog;

import java.io.File;
import java.lang.reflect.Field;

import static com.josebran.LogsJB.Executores.Execute.getInstance;
import static com.josebran.LogsJB.Executores.Execute.getListado;

public  class LogsJB extends Methods{


    /***
     * Obtiene la ruta donde se estara escribiendo el Log.
     * @return Retorna un String con la ruta del archivo .Txt donde se estara escribiendo el Log.
     */
    public static String getRuta() {
        return Methods.ruta;
    }

    /**
     * Setea la ruta en la cual se desea que escriba el Log.
     * @param Ruta Ruta del archivo .Txt donde se desea escribir el Log.
     */
    public static void setRuta(String Ruta) {
        try{
            Field field = Methods.class.getDeclaredField("ruta");
            field.setAccessible(true);
            field.set(null, Ruta);
        }catch (Exception e){
            System.out.println("Excepcion capturada al tratar de setear la ruta del log " +Ruta);
        }
    }


    /***
     * Obtiene el grado del log, sobre el cual se estara realizando el seguimiento de los mensajes que se
     * escriben en las bitacoras de Log de la aplicación actual.
     * Trace = 200,
     * Debug = 400,
     * Info = 500,
     * Warning = 600,
     * Error = 800,
     * Fatal = 1000.
     * @return Retorna un NivelLog el cual expresa el Nivel Log desde el cual se estara reportando al Log y sus
     * superiores, El valor por defaul es Info.
     */
    public static NivelLog getGradeLog() {
        return Methods.gradeLog;
    }

    /***
     * Setea el NivelLog desde el cual deseamos se escriba en el Log de la aplicación actual.
     * @param GradeLog Nivel Log desde el cual hacía arriba en la jerarquia de logs, deseamos se reporten
     *      * Trace = 200,
     *      * Debug = 400,
     *      * Info = 500,
     *      * Warning = 600,
     *      * Error = 800,
     *      * Fatal = 1000.
     * El valor por defaul es Info.
     */
    public static void setGradeLog(NivelLog GradeLog) {
        try{
            Field field = Methods.class.getDeclaredField("gradeLog");
            field.setAccessible(true);
            field.set(null, GradeLog);
            //Methods.metodo = metodo;
        }catch (Exception e){
            System.out.println("Excepcion capturada al tratar de setear el GradeLog de la aplicación " +GradeLog);
        }
    }

    /****
     * Obtiene el tamaño maximo actual definido para el fichero de Log sobre el cual se estara escribiendo.
     * @return Retorna un SizeLog que representa el tamaño configurado para el archivo log de la aplicación,
     * El valor por defaul es Little_Little.
     */
    public static SizeLog getSizeLog() {
        return Methods.sizeLog;
    }

    /***
     * Setea el tamaño maximo para el archivo Log de la aplicación actual.
     * @param SizeLog Tamaño maximo del archivo sobre el cual se estara escribiendo el Log.
     *      * Little_Little = 125Mb,
     *      * Little = 250Mb,
     *      * Small_Medium = 500Mb,
     *      * Medium = 1,000Mb,
     *      * Small_Large = 2,000Mb,
     *      * Large = 4,000Mb.
     * El valor por defaul es Little_Little.
     */
    public static void setSizeLog(SizeLog SizeLog) {
        try{
            Field field = Methods.class.getDeclaredField("sizeLog");
            field.setAccessible(true);
            field.set(null, SizeLog);
            //Methods.metodo = metodo;
        }catch (Exception e){
            System.out.println("Excepcion capturada al tratar de setear el Tamaño del archivo Log " +SizeLog);
        }
    }

/**/
    public static void main(String[] args) {
        try{
            int archivos=0;
            File archivo = new File(getRuta());
            while(archivos<3){
                try{
                    //LogsJB.setRuta("C:/Reportes/Logs/Log.txt");
                    executor(NivelLog.DEBUG, "Ruta donde se esta escribiendo el log: "+getRuta());

                    debug( "Primer comentario grado Debug");

                    error( "Primer comentario grado Error");

                    fatal( "Primer comentario grado Fatal");

                    info( "Primer comentario grado Info");

                    trace( "Primer comentario grado Trace");

                    warning( "Primer comentario grado Warning");

                    debug("Jbran");

                    //Thread.sleep(100);
                    File carpeta = new File(archivo.getParent());
                    File[] listado;
                    listado = carpeta.listFiles();
                    archivos=listado.length;

                    //System.out.println("Cantida de archivos: "+archivos);
                    if(archivos>1){
                        return;
                    }

                    //archivos=new File(getRuta()).list().length;
                    //System.out.println("Cantida de archivos: "+archivos);
                }catch (Exception e){
                    System.out.println("Excepcion capturada en el metodo main: "+e.getMessage());
                }


            }
            System.out.println("Salio del While: "+archivos);
        }catch (Exception e){
            System.out.println("Excepcion capturada en el metodo main: "+e.getMessage());
        }


    }



/*
    public static void main(String[] args) {
    try{

            ///LogsJB.setRuta("C:/Reportes/Logs/Log.txt");
        executor(NivelLog.DEBUG, "Ruta donde se esta escribiendo el log: "+getRuta());
        //Thread.sleep(1);
        debug( "Primer comentario grado Debug");
        //Thread.sleep(1);
        error( "Primer comentario grado Error");
        //Thread.sleep(1);
        fatal( "Primer comentario grado Fatal");
        //Thread.sleep(1);
        info( "Primer comentario grado Info");
        //Thread.sleep(1);
        trace( "Primer comentario grado Trace");
        //Thread.sleep(1);
        warning( "Primer comentario grado Warning");
        //Thread.sleep(1);
        debug("Jbran");
        //Thread.sleep(1);
        //System.exit(100);
        return;

    }catch (Exception e){
        System.out.println("Excepcion capturada en el metodo main: "+e.getMessage());
    }
}

*/
    /***
     * Procedimiento encargado de hacer la llamada al ejecutor en un hilo de ejecución aparte, para que este se encargue
     * de ejecutar los ejecutores de log's en subprocesos, diferentes al programa principal
     * @param nivelLog NivelLog del mensaje que queremos almacenar en el Log.
     * @param Texto Texto que se desea escribir en el Log.
     */
    protected static void executor(NivelLog nivelLog, String Texto){
        //try{
            //Permitira obtener la pila de procesos asociados a la ejecuciòn actual
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            String clase = null;
            String metodo = null;
            try{
                clase = elements[3].getClassName();
                metodo = elements[3].getMethodName();
            }catch (Exception ex){
                clase = elements[2].getClassName();
                metodo = elements[2].getMethodName();
            }
            Methods.setClase(clase);
            Methods.setMetodo(metodo);

            MensajeWrite mensaje=new MensajeWrite();
            mensaje.setTexto(Texto);
            mensaje.setNivelLog(nivelLog);
            //System.out.println("Agregara el dato: "+Thread.currentThread().getName());
            getListado().addDato(mensaje);
            //System.out.println("Correra el metodo run: "+Thread.currentThread().getName());
            getInstance().run();
            //System.out.println("Nombre hilo Execute: "+Thread.currentThread().getName());
            //getInstance().setNivelLog(nivelLog);
            //getInstance().setTexto(Texto);

            //getMensajes().add(mensaje);
            //if(getInstance().getState()!= Thread.State.RUNNABLE){
                //Execute writer= getInstance();
                /*
                if(Execute.getInstance().isAlive()){
                    System.out.println("Despertara el Execute: "+Thread.currentThread().getName());
                    Execute.getInstance().resume();
                }*/
            //}else{
                //System.out.println("El hilo execute esta corriendo");
           //}

        //}catch (Exception e){
         //   System.out.println("Excepcion capturada al Executor encargado de llamar al proceso asincrono " +nivelLog.toString()+": "+e.getMessage());
        //}


    }

    /***
     * Procedimiento encargado de hacer la llamada al ejecutor en un hilo de ejecución aparte, para que este se encargue
     * de ejecutar los ejecutores de log's en subprocesos, diferentes al programa principal
     * @param nivelLog NivelLog del mensaje que queremos almacenar en el Log.
     * @param Texto Texto que se desea escribir en el Log.
     * @param clase Clase a la que pertenece el metodo desde el que se desea escribir el Log.
     * @param metodo Metodo desde el que se llama la escritura del Log.
     *//*
    protected static void executor(NivelLog nivelLog, String Texto, String clase, String metodo){
        try{
            //Permitira obtener la pila de procesos asociados a la ejecuciòn actual
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            Methods.setClase(clase);
            Methods.setMetodo(metodo);
            Execute writer= new Execute();
            writer.setMensaje(Texto);
            writer.setNivellog(nivelLog);
            writer.start();
            while(writer.getState()!= Thread.State.TERMINATED){

            }
        }catch (Exception e){
            System.out.println("Excepcion capturada al Executor encargado de llamar al proceso asincrono " +nivelLog.toString()+": "+e.getMessage());
        }


    }

*/
    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria de Informacion.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void info(String Texto){
        executor(NivelLog.INFO, Texto);
    }

    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria de Debug.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void debug(String Texto){
        executor(NivelLog.DEBUG, Texto);
    }
    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria de Trace, la cual es un seguimiento mayor a Debug.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void trace(String Texto){
        executor(NivelLog.TRACE, Texto);
    }

    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria de Advertencia.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void warning(String Texto){
        executor(NivelLog.WARNING, Texto);
    }

    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria Fatal lo cual indica un error del cual no es posible recuperarse.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void fatal(String Texto){
        executor(NivelLog.FATAL, Texto);
    }

    /***
     * Escribe en el Log el mensaje especificado indicando que pertenece a la categoria de Error, lo cual indica que capturo un error.
     * @param Texto Texto que se desea escribir en el Log.
     */
    public static void error(String Texto){
        executor(NivelLog.ERROR, Texto);
    }



}
