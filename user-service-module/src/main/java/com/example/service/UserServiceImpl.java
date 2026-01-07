import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@Override
@CircuitBreaker(name = "userService", fallbackMethod = "myGetUserByIdFallback")
@Retry(name = "userService")
@Transactional(readOnly = true)
public UserResponseDto myGetUserById(Long myUserId) {
    myLoggerInstance.info("Fetching user with ID: {}", myUserId);
    
    UserEntity myUserEntity = myUserRepository.findById(myUserId)
            .orElseThrow(() -> new NotFoundException("Пользователь не найден с ID: " + myUserId));
    
    return myConvertToDto(myUserEntity);
}

public UserResponseDto myGetUserByIdFallback(Long myUserId, Throwable myThrowable) {
    myLoggerInstance.error("Fallback for getUserById with ID: {}, Error: {}", 
                          myUserId, myThrowable.getMessage());
    

    UserResponseDto myFallbackResponse = new UserResponseDto();
    myFallbackResponse.setUserId(myUserId);
    myFallbackResponse.setUserName("Service Temporary Unavailable");
    myFallbackResponse.setUserEmail("fallback@example.com");
    myFallbackResponse.setUserAge(0);
    
    return myFallbackResponse;
}