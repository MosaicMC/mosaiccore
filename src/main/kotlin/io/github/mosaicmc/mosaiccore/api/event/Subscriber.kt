/*
 * Copyright (c) 2023. JustFoxx
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.mosaicmc.mosaiccore.api.event

/**
 * Subscriber
 *
 * Subscriber is a functional interface that accepts an event object
 *
 * @param E The event type
 */
fun interface Subscriber<E : Event> {
    fun accept(event: E)
}

/**
 * Annotation used to mark methods to be used as event subscribers.
 *
 * @property priority the priority of the subscriber, defaulting to [Priority.NORMAL].
 * @property ignoreCancelled whether events canceled should be ignored, defaulting to false.
 */
annotation class SubscriberData(
    val priority: Priority = Priority.NORMAL,
    val ignoreCancelled: Boolean = false
)

/**
 * Priority
 *
 * Priority of an event subscriber. If there are multiple subscribers for an event, subscribers with
 * higher priority are called before those with lower priority.
 *
 * @constructor Create empty Priority
 * @property HIGHEST
 * @property HIGH
 * @property NORMAL (default)
 * @property LOW
 * @property LOWEST
 */
enum class Priority {
    HIGHEST,
    HIGH,
    NORMAL,
    LOW,
    LOWEST
}
