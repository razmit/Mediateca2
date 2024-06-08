package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.LibroDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Libro;
import com.boombastic.mediateca.utils.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {

    List<LibroDto> listAllLibros();

    LibroDto findLibroById(Long libroId);

    void saveLibro(Libro libro);

    void updateLibro(LibroDto libroDto);

    void delete(Long libroId);
}
