/*
Buatlah Program Sederhana menggunakan Operator, statemen IF dengan kasus berikut:

Pada sebuah perusahaan dengan tiga golongan Karyawan, yaitu:

Jika Golongan A: Gaji Rp. 5.000.000
Jika Golongan B: Gaji Rp. 6.500.000
Jika Golongan C: Gaji Rp. 9.500.000

Jika karyawan tersebut lembur, maka mereka dibayar per-Jam dengan ketentuan sebagai berikut:

Jika Karyawan lembur 1 Jam maka gaji lemburnya 30% dari Gaji Pokok
Jika Karyawan lembur 2 Jam maka gaji lemburnya 32% dari Gaji Pokok
Jika Karyawan lembur 3 Jam maka gaji lemburnya 34% dari Gaji Pokok
Jika Karyawan lembur 4 Jam maka gaji lemburnya 36% dari Gaji Pokok
Jika Karyawan lembur >= 5 Jam maka gaji lemburnya 38% dari Gaji Pokok

Inputan pada Program adalah Golongan dan Jam Lembur.

Output (Tampilan ke Layar) Jumlah penghasilan: Gaji Golongan + Gaji Lembur.
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class CountSalary {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      double total_salary = 0;
      double total_overtime = 0;
      boolean is_error = false;

      System.out.println("================\nCount Total Salary\n================\n");
      System.out.println("Input Employee Category (only allowed A | B | C Category):");
      String category = scanner.nextLine().toUpperCase();

      System.out.println("\nInput Overtime Duration");
      double overtime_duration = scanner.nextInt();

      System.out.println("\n");

      switch (category) {
        case "A":
          total_salary = 5_000_000;
          break;
        case "B":
          total_salary = 6_500_000;
          break;
        case "C":
          total_salary = 9_500_000;
          break;

        default:
          is_error = true;
          System.out.println("Category " + category + " is Invalid");
          break;
      }

      if (overtime_duration >= 5) {
        total_overtime = total_salary * 0.38;
      } else if (overtime_duration >= 1) {
        total_overtime = total_salary * (0.28 + (overtime_duration * 0.02));
      } else {
        is_error = true;
        System.out.println("Minimum duration is 1 hour");
      }

      DecimalFormat df = new DecimalFormat("###,###,###.##");

      if (!is_error) {
        System.out.println("Base Salary : " + df.format(total_salary) + "\n");
        System.out.println("Overtime Salary : " + df.format(total_overtime) + "\n");

        System.out.println("Total Salary : " + df.format(total_salary + total_overtime));
      }
    }
  }
}