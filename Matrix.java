public class Matrix {

    final private int row;
    final private int col;
    final private double[][] mat;

    public Matrix(double[][] mat) {
        this.mat = mat;
        this.row = mat.length;
        this.col = mat[0].length;
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.mat = new double[row][col];
    }

    private static int changeSign(int i, int j) {
        return (i + j) % 2 == 0 ? 1 : -1;
    }

    private boolean isSquare() {
        return row == col;
    }

    private Matrix createSubMatrix(Matrix mat, int n, int m) {
        Matrix subMatrix = new Matrix(mat.getRows() - 1, mat.getColumns() - 1);
        int r = 0;
        for (int i = 0; i < mat.getRows(); i++) {
            if (n == i) {
                continue;
            }
            int c = 0;
            for (int j = 0; j < mat.getColumns(); j++) {
                if (m == j) {
                    continue;
                }
                subMatrix.setValueAt(r, c, mat.getValueAt(i, j));
                c++;
            }
            r++;
        }
        return subMatrix;
    }

    private void swap(int i, int j) {
        double temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public void setValueAt(int i, int j, double valueAt) {
        mat[i][j] = valueAt;
    }

    public int getRows() {
        return row;
    }

    public int getColumns() {
        return col;
    }

    public double getValueAt(int i, int j) {
        return mat[i][j];
    }

    public void transpose() {
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                swap(i, j);
            }
        }
    }

    public double determinant(Matrix mat) {
        if (!mat.isSquare()) {
            System.out.println("Matrix is not square matrix");
            return 0;
        }
        if (mat.getRows() == 1) {
            return mat.getValueAt(0, 0);
        }
        if (mat.getRows() == 2) {
            return mat.getValueAt(0, 0) * mat.getValueAt(1, 1)
                   - mat.getValueAt(1, 0) * mat.getValueAt(0, 1);
        }
        double sum = 0.0;
        for (int i = 0; i < mat.getRows(); i++) {
            sum += changeSign(0, i) * mat.getValueAt(0, i) * determinant(createSubMatrix(mat, 0, i));
        }
        return sum;
    }

    public double determinant() {
        return determinant(this);
    }

    public Matrix cofactorMatrix(Matrix mat) {
        Matrix cofactor = new Matrix(mat.getRows(), mat.getColumns());
        for (int i = 0; i < mat.getRows(); i++) {
            for (int j = 0; j < mat.getColumns(); j++) {
                cofactor.setValueAt(i, j, changeSign(i, j) * determinant(createSubMatrix(mat, i, j)));
            }
        }
        return cofactor;
    }

    public Matrix cofactorMatrix() {
        return cofactorMatrix(this);
    }

    public Matrix adjointMatrix() {
        Matrix cofactor = cofactorMatrix(this);
        cofactor.transpose();
        return cofactor;
    }

    public void multipleByConstant(double mul) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] *= mul;
            }
        }
    }

    public Matrix inverse() {
        Matrix adjacaency = this.adjointMatrix();
        adjacaency.multipleByConstant(1 / this.determinant());
        return adjacaency;
    }

    public Matrix multiplyMatrix(Matrix mat) {
        if (this.getColumns() != mat.getRows()) {
            System.out.println("Can't be multipied."
                               + " Please check the dimensional of the Matrices");
            return new Matrix(0, 0);
        } else {
            Matrix mul = new Matrix(this.getRows(), mat.getColumns());
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < mat.getColumns(); j++) {
                    double sum = 0;
                    for (int k = 0; k < this.getColumns(); k++) {
                        sum += this.getValueAt(i, k) * mat.getValueAt(k, j);
                    }
                    mul.setValueAt(i, j, sum);
                }
            }
            return mul;
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }
}
