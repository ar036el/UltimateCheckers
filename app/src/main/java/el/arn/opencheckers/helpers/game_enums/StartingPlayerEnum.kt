/*******************************************************
 * Copyright (C) 2020-2021 ArealApps areal.apps@gmail.com
 *
 * This file and project cannot be copied and/or distributed without the explicit
 * permission of ArealApps. All Rights Reserved.
 *******************************************************/

package el.arn.opencheckers.helpers.game_enums

import el.arn.opencheckers.helpers.EnumWithId

enum class StartingPlayerEnum(override val id: String) : EnumWithId { White("White"), Black("Black"), Random("Random") }