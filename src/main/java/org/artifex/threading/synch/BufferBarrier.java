package org.artifex.threading.synch;

import org.artifex.threading.VkAccessFlagBits;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkMemoryBarrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_MEMORY_BARRIER;

public class BufferBarrier
{

    public BufferBarrier(VkAccessFlagBits srcMask, VkAccessFlagBits dstMask)
    {
        bufferBarrier = VkBufferMemoryBarrier.calloc()
                .dstAccessMask(dstMask.get())
                .srcAccessMask(srcMask.get())
                .sType(VK_STRUCTURE_TYPE_MEMORY_BARRIER);
    }


    public void cleanup(){
        bufferBarrier.free();
    }
    public VkBufferMemoryBarrier getBufferBarrier() {
        return bufferBarrier;
    }

    private final VkBufferMemoryBarrier bufferBarrier;
}
