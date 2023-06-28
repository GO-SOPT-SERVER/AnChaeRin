package sopt.org.fouthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.fouthSeminar.controller.dto.BoardImageListRequestDto;
import sopt.org.fouthSeminar.controller.dto.BoardRequestDto;
import sopt.org.fouthSeminar.domain.Board;
import sopt.org.fouthSeminar.domain.Image;
import sopt.org.fouthSeminar.domain.User;
import sopt.org.fouthSeminar.exception.Error;
import sopt.org.fouthSeminar.exception.model.NotFoundException;
import sopt.org.fouthSeminar.infrastructure.BoardRepository;
import sopt.org.fouthSeminar.infrastructure.ImageRepository;
import sopt.org.fouthSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, List<String> boardImageUrlList, BoardImageListRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        // 이미지 생성
        for (String boardImageUrl: boardImageUrlList) {
            imageRepository.save(Image.newInstance(newBoard, boardImageUrl));
        }
    }
}
