package core;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.setDenominador(denominador);
    }


    public static Fraccion suma(Fraccion f1, Fraccion f2){
        int den = f1.getDenominador() * f2.getDenominador();
        int num = f1.getNumerador() * f2.getDenominador() + f2.getNumerador() * f1.getDenominador();
        return new Fraccion(num, den).reducir();
    }

    public static Fraccion suma(Fraccion f, int i){
        return suma(f, new Fraccion(i, 1));
    }

    public static Fraccion resta(Fraccion f1, Fraccion f2){
        int den = f1.getDenominador() * f2.getDenominador();
        int num = f1.getNumerador() * f2.getDenominador() - f2.getNumerador() * f1.getDenominador();
        return new Fraccion(num, den).reducir();
    }

    public static Fraccion resta(Fraccion f, int i){
        return resta(f, new Fraccion(i, 1));
    }

    public static Fraccion multiplicacion(Fraccion f1, Fraccion f2){
        int num = f1.getNumerador() * f2.getNumerador();
        int den = f1.getDenominador() * f2.getDenominador();

        return new Fraccion(num, den).reducir();
    }

    public static Fraccion multiplicacion(Fraccion f, int i){
        return multiplicacion(f, new Fraccion(i, 1));
    }

    public static Fraccion division(Fraccion f1, Fraccion f2){
        try {
            int num = f1.getNumerador() * f2.getDenominador();
            int den = f1.getDenominador() * f2.getNumerador();

            if(den == 0) throw new ArithmeticException("No se puede dividir por cero");

            return new Fraccion(num, den).reducir();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Fraccion division(Fraccion f, int i){
        return division(f, new Fraccion(i, 1));
    }


    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
            this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        try{
            if(denominador == 0) throw new RuntimeException("El denominador no puede ser cero");
            this.denominador = denominador;
        } catch (Exception e){
            throw new ArithmeticException(e.getMessage());
        }
    }

    /**
     * Maximo comun divisor
     * @param a
     * @param b
     */
    private int MCD(int a, int b){
        if (b == 0) return a;
        return MCD(b, a % b);
    }

    /**
     * Reduce la fraccion dada a su minima expresion
     */
    private Fraccion reducir(){
        int mcd = MCD(this.getNumerador(), this.getDenominador());

        if(mcd == 1) return this;

        this.setNumerador(this.getNumerador() / mcd);
        this.setDenominador(this.getDenominador() / mcd);

        return this;
    }

    @Override
    public String toString(){
        if(this.numerador < 0 || this.denominador < 0){
            return "-(" + Math.abs(this.numerador) + "/" +  Math.abs(this.denominador) + ")";
        }
        return this.numerador + "/" + this.denominador;
    }
}
