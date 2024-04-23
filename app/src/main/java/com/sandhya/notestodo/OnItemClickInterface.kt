package com.sandhya.notestodo

import com.sandhya.notestodo.modules.Notes

interface OnItemClickInterface {
    fun edit(notes: Notes)
    fun delete(notes: Notes)
}