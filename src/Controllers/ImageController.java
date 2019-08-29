package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Database.*;
import Models.Images;

public class ImageController {
    public void store (Images file) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("INSERT INTO images (image) VALUES (?)");

            stmt.setBytes(1, file.getImage());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Imagem cadastrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar imagem!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }

    public List<Images> index () {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet results = null;

        List<Images> listaImages = new ArrayList<>();

        try {
            stmt = connect.prepareStatement("SELECT * FROM images");
            results = stmt.executeQuery();

            while (results.next()) {
                Images file = new Images();

                file.setId(results.getInt("id"));
                file.setImage(results.getBytes("images"));

                listaImages.add(file);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar a lista de imagens!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, results);
        }

        return listaImages;
    }

    public void destroy (Images file) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
          stmt = connect.prepareStatement("DELETE FROM images WHERE id = ?");

          stmt.setInt(1, file.getId());

          stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Imagem excluída com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a imagem!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
}
