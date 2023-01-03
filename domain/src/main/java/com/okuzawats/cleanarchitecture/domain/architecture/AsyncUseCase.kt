package com.okuzawats.cleanarchitecture.domain.architecture

import kotlinx.coroutines.flow.Flow

/**
 * interface that each UseCase should implement
 *
 * @param RESULT type that UseCase returns as Flow
 */
interface AsyncUseCase<RESULT: Any> {
  suspend operator fun invoke(): Flow<RESULT>
}
