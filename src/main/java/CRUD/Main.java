package CRUD;

import java.sql.*;

public class Main {

    public static final String URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11697401";
    public static final String KULLANICIADI = "sql11697401";
    public static final String SIFRE = "XhRXzdevqY";
    public static final String TABLO = "aysubusra_muratoglu";

    public static void main(String[] args) {
        select();
        insert("11111111111","Test","TestSoyad",1);
        insert("11111111112","Aysu","Muratoglu",30);
        insert("11111111113","Hilal","Yuzseven",30);
        insert("11111111114","Gulsah","Okumus",29);
        select("11111111112");
        update("11111111111", "Busra");
        delete("11111111111");
        select();
    }

    public static void update(String tc, String yeniAd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, KULLANICIADI, SIFRE);

            String updateQuery = "UPDATE " + TABLO + " SET Ad = ? WHERE TC = ?";
            System.out.println("Yapilacak query= " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);

            int i = 1;
            preparedStatement.setString(i++, yeniAd);
            preparedStatement.setString(i++, tc);


            int resultCount = preparedStatement.executeUpdate();

            System.out.println("Etkilenen satir sayisi= " + resultCount);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static void delete(String tc) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, KULLANICIADI, SIFRE);

            String updateQuery = "DELETE FROM " + TABLO + " WHERE TC = ?";
            System.out.println("Yapilacak query= " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, tc);

            int resultCount = preparedStatement.executeUpdate();

            System.out.println("Etkilenen satir sayisi= " + resultCount);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }





    public static void select(String tc) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, KULLANICIADI, SIFRE);

            String selectQuery = "SELECT * FROM " + TABLO + " WHERE TC = ?";

            preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setString(1, tc);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tc_ = resultSet.getString("TC");
                String ad = resultSet.getString("Ad");
                String soyad = resultSet.getString("Soyad");
                int yas = resultSet.getInt("Yas");

                System.out.println("TC: " + tc_ + ", Ad: " + ad+ ", Soyad: " + soyad + ", Yas: " + yas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static void select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, KULLANICIADI, SIFRE);

            String selectQuery = "SELECT * FROM " + TABLO;

            preparedStatement = connection.prepareStatement(selectQuery);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tc_ = resultSet.getString("TC");
                String ad = resultSet.getString("Ad");
                String soyad = resultSet.getString("Soyad");
                int yas = resultSet.getInt("Yas");


                System.out.println("TC: " + tc_ + ", Ad: " + ad+ ", Soyad: " + soyad + ", Yas: " + yas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }







    public static void insert(String tc, String ad, String soyad, int yas) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, KULLANICIADI, SIFRE);

            String insertQuery = "INSERT INTO " + TABLO + "(TC, Ad, Soyad, Yas) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(insertQuery);

            int i = 1;
            preparedStatement.setString(i++, tc);
            preparedStatement.setString(i++, ad);
            preparedStatement.setString(i++, soyad);
            preparedStatement.setInt(i++, yas);

            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //resultSet.close();
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
