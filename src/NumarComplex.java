public class NumarComplex {
    private double re;
    private double im;

    //constructors
    public NumarComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public NumarComplex() {}

    //getters si setters
    public double getRe() {
        return re;
    }
    public void setRe(double re) {
        this.re = re;
    }
    public double getIm() {
        return im;
    }
    public void setIm(double im) {
        this.im = im;
    }

    public NumarComplex conjugat() {
        return new NumarComplex(this.getRe(), -this.getIm());
    }

    public NumarComplex adunare(NumarComplex nr) {
        return new NumarComplex(re + nr.getRe(), im + nr.getIm());
    }

    public NumarComplex scadere(NumarComplex nr) {
        return new NumarComplex(re - nr.getRe(), im - nr.getIm());
    }

    public NumarComplex inmultire(NumarComplex nr) {
        double real = re * nr.getRe() - im * nr.getIm();
        double imaginar = re * nr.getIm() + im * nr.getRe();
        return new NumarComplex(real, imaginar);
    }

    public NumarComplex impartire(NumarComplex nr) {
        // trebuie sa inmultesc fractia cu conjugatul lui nr ( deimpartitul si impartitorul )
        NumarComplex deimpartit = this.inmultire(nr.conjugat());
        double impartitor = nr.getRe() * nr.getRe() + nr.getIm() * nr.getIm();

        return new NumarComplex(deimpartit.getRe() / impartitor, deimpartit.getIm() / impartitor);
    }

    @Override
    public String toString() {
        String rezultat = new String();
        rezultat += re;
        if (im < 0)
            if (im == -1)
                rezultat += "-i";
            else
                rezultat += im + "*i";
        else if (im == 1)
            rezultat += "+i";
        else if (im != 0)
            rezultat += "+" + im + "*i";
        return rezultat;
    }
}
