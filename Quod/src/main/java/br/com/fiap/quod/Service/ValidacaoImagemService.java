package br.com.fiap.quod.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class ValidacaoImagemService {

    private static final long TAMANHO_MAXIMO = 5 * 1024 * 1024; // 5 MB
    private static final int RESOLUCAO_MINIMA = 300; // 300x300 pixels

    public boolean validarFormato(MultipartFile imagem) {
        String contentType = imagem.getContentType();
        return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
    }

    public boolean validarTamanho(MultipartFile imagem) {
        return imagem.getSize() <= TAMANHO_MAXIMO;
    }

    public boolean validarResolucao(MultipartFile imagem) {
        try {
            BufferedImage bufferedImage = ImageIO.read(imagem.getInputStream());
            return bufferedImage != null && bufferedImage.getWidth() >= RESOLUCAO_MINIMA && bufferedImage.getHeight() >= RESOLUCAO_MINIMA;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean validarImagem(MultipartFile imagem) {
        return validarFormato(imagem) && validarTamanho(imagem) && validarResolucao(imagem);
    }
}
