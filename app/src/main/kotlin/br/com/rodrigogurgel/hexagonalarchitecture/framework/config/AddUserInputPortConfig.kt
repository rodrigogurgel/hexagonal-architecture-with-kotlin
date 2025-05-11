package br.com.rodrigogurgel.hexagonalarchitecture.framework.config

import br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user.AddUserInputPort
import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.datastore.UserDatastoreOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AddUserInputPortConfig {
    @Bean
    fun addUserInputPort(userDatastoreOutputPort: UserDatastoreOutputPort): AddUserInputPort {
        return AddUserInputPort(userDatastoreOutputPort)
    }
}
