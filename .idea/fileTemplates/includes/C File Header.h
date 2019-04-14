#if ($HEADER_COMMENTS)
//
#set( $USER_NAME = "Your name" )
#set($ORGANIZATION_NAME="clea")

// Created by $USER_NAME on ${DATE}.
#if ($ORGANIZATION_NAME && $ORGANIZATION_NAME != "")
// Copyright (c) $YEAR ${ORGANIZATION_NAME}#if (!$ORGANIZATION_NAME.endsWith(".")).#end All rights reserved.
#end
//
#end