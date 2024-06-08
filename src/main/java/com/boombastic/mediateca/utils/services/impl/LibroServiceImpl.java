package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.LibroDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Libro;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.LibroService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {


    @Override
    public List<LibroDto> listAllLibros() {
        return List.of();
    }

    @Override
    public LibroDto findLibroById(Long libroId) {
        return null;
    }

    @Override
    public void saveLibro(Libro libro) {

    }

    @Override
    public void updateLibro(LibroDto libroDto) {

    }

    @Override
    public void delete(Long libroId) {

    }
}
